package com.enea.sd.example.importer;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.zealcore.se.core.IExtendedImporter;
import com.zealcore.se.core.ImportException;
import com.zealcore.se.core.format.FieldDescription;
import com.zealcore.se.core.format.FieldValues;
import com.zealcore.se.core.format.GenericArtifactInfo;
import com.zealcore.se.core.format.GenericEventInfo;
import com.zealcore.se.core.format.ReceiveEventInfo;
import com.zealcore.se.core.format.SendEventInfo;
import com.zealcore.se.core.format.TaskArtifactInfo;
import com.zealcore.se.core.format.TaskSwitchEventInfo;
import com.zealcore.se.core.format.TypeDescription;
import com.zealcore.se.core.format.FieldDescription.FieldType;
import com.zealcore.se.core.format.TaskArtifactInfo.TaskClass;
import com.zealcore.se.core.ifw.ImportContext;
import com.zealcore.se.core.model.ISequence;
import com.zealcore.se.core.model.LogFile;
import com.zealcore.se.core.model.generic.GenericLogEvent;
import com.zealcore.se.core.model.generic.GenericLogFile;
import com.zealcore.se.core.model.generic.GenericSequence;
import com.zealcore.se.core.model.generic.GenericTask;
import com.zealcore.se.core.util.TimestampUtil;

/**
 * The SimpleExtendedImporter is an example importer that can be used together
 * with Log Analyzer to import log files of a specified format.
 * <p>
 * The importer is able to create task/process switches and sequences that are
 * needed to populate the Gantt and Sequence diagrams. There are still more
 * properties that can be implemented to fulfill the log events properties. A
 * few examples are;
 * <p>
 * 1) send events does not display at what time stamp the message is received.
 * <p>
 * 2) receive events does not display at what time stamp the message was sent.
 * <p>
 * It is up to the implementer to create the mechanisms that match send and
 * receives.
 * <p>
 * The log file format is on the following format:
 * <p>
 * <pre>
 * YYYY-MM-DD hh:mm:ss:us MESSAGE_TYPE
 *
 * * YYYY = year
 *
 * * MM = month
 *
 * * DD = day
 *
 * * hh = hour
 *
 * * mm = minute
 *
 * * ss = second
 *
 * * us = micro second
 *
 * * MESSAGE_TYPE and MESSAGE_PARAMETERS = The type of the message and its
 * parameters that are needed. The message type can be one of the following:
 *
 * -- SYSTEM_INFO <message> = An informative message. The message can be
 *
 * -- TASK_SWITCH <out task> <in task> = Indicates that the current task/process
 * is switched out and another is switched in.
 *
 * -- SEND <sender> <receiver> <message> = A message is sent from one
 * object/task/process to another.
 *
 * -- RECEIVE <sender> <receiver> <message> = A message is received from one
 * object/task/process.
 * </pre>
 * <p>
 * The following is an example log file that can be imported by the
 * SimpleImporter. Copy the content and save it as a text file called simple.log
 * (remove the Java comments)
 * <p>
 * <pre>
 * ####### Example Log File Begin #######
 * #Enea Example Log
 * #Version 1.1
 *
 * 2007-03-28 13:56:00:900004 SYSTEM_INFO Temperature is OK!
 * 2007-03-28 13:56:00:900013 TASK_SWITCH system engine_unit
 * 2007-03-28 13:56:00:900102 SEND engine_unit control_unit RPM limit reached
 * 2007-03-28 13:56:00:900106 TASK_SWITCH engine_unit control_unit
 * 2007-03-28 13:56:00:900237 RECEIVE control_unit RPM limit reached
 * 2007-03-28 13:56:00:900213 TASK_SWITCH control_unit system
 * 2007-03-28 13:56:00:900307 SYSTEM_INFO Adjusting parameters to decrease temperature
 * 2007-03-28 13:56:00:900319 SYSTEM_INFO Should not reach this state
 * 2007-03-28 13:56:00:900391 TASK_SWITCH system control_unit
 * 2007-03-28 13:56:00:900413 SEND control_unit engine_unit Error, stop engine
 * 2007-03-28 13:56:00:900472 TASK_SWITCH control_unit system
 * 2007-03-28 13:56:00:900510 SYSTEM_INFO Temperature is rising
 * 2007-03-28 13:56:00:900562 TASK_SWITCH system engine_unit
 * 2007-03-28 13:56:00:900600 RECEIVE engine_unit Error, stop engine
 * 2007-03-28 13:56:00:900622 TASK_SWITCH engine_unit system
 * 2007-03-28 13:56:00:900746 SYSTEM_INFO warning, system in fail state!
 * 2007-03-28 13:56:00:901239 SYSTEM_INFO System restart is ordered from safety mechanism!
 *
 * ####### Example Log File End #######
 * </pre>
 */
public class SimpleExtendedImporter implements IExtendedImporter, Closeable {

    private static final String SYSTEM_INFO = "SYSTEM_INFO";

    private static final String TASK_SWITCH = "TASK_SWITCH";

    private static final String RECEIVE = "RECEIVE";

    private static final String SEND = "SEND";

    private static final String NUMBER = "\\d+";

    private static final String WS = "\\s+";

    private static final String WILD_CARD = ".+";

    private static final String REGEXP = "(" + NUMBER + ")-(" + NUMBER + ")-("
            + NUMBER + ")" + WS + "(" + NUMBER + "):(" + NUMBER + "):("
            + NUMBER + "):(" + NUMBER + ")\\s([A-Z_]+)" + WS + "(" + WILD_CARD
            + ")";

    private static final String SYSTEM_INFO_PARAMS = "([A-Za-z\\d\\D]+)";

    private static final String SEND_PARAMS = "([A-Za-z_]+)" + WS
            + "([A-Za-z_]+)" + WS + "(.*)";

    private static final String TASKSWITCH_PARAMS = "([A-Za-z_\\d]+)" + WS
            + "([A-Za-z_\\d]+)";

    private static final String RECEIVE_PARAMS = "([A-Za-z_]+)" + WS + "("
            + WILD_CARD + ")";

    private BufferedReader logFileReader;

    private ImportContext importContext;

    private File file;

    private Map <String, GenericTask> artifacts = new HashMap <String, GenericTask> ();

    private GenericSequence sequence;

    private GenericLogFile genericLogFile;

    private Map <Long, GenericArtifactInfo> artifactList = new HashMap <Long, GenericArtifactInfo> ();

    public Map <Long, GenericArtifactInfo>  getArtifactList() {
        return artifactList;
    }

    public boolean canRead(final File file) {
        boolean retValue = false;
        if (file.canRead() && file.getName().endsWith(".log")) {

            try {
                logFileReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                return false;
            }
            try {
                String line = logFileReader.readLine();
                if ("#Enea Example Log".equals(line)) {
                    retValue = true;
                }
            } catch (IOException e) {
                retValue = false;
            }
        }
        try {
            if (logFileReader != null) {
                logFileReader.close();
            }
        } catch (IOException e) {
            retValue = false;
        }
        return retValue;
    }

    public Iterable <GenericArtifactInfo>  getArtifacts() {
        return artifactList.values();
    }

    public Iterable <GenericEventInfo>  getEvents() {
        try {
            initialize();
        } catch (IOException e) {
            throw new ImportException("Failed to read events from file: "
                    + this.importContext.getFile().getAbsolutePath(), e);
        }

        return new Iterable <GenericEventInfo> () {
            public Iterator <GenericEventInfo>  iterator() {
                return new StringElementIterator();
            }
        };
    }

    @Override
    public String toString() {
        return "Simple Importer (c) Enea 2008";
    }

    /**
     * Sets up the importer before it can start reading log events.
     * 
     * @throws IOException
     */
    private void initialize() throws IOException {
        logFileReader = new BufferedReader(new FileReader(file));

        /**
         * Read header
         */
        String line = logFileReader.readLine();
        if (!"#Enea Example Log".equals(line)) {
            throw new ImportException("Failed to match header \""
                    + "#Enea Example Log" + "\" with line \"" + line + "\"");
        }

        line = logFileReader.readLine();
        if (!"#Version 1.1".equals(line)) {
            throw new ImportException("Only version 1.0 is supported!");
        }
        genericLogFile = new GenericLogFile();
        genericLogFile.setFileName(importContext.getFile().getName());
        genericLogFile.setImporterId(this.getClass().getName());
        genericLogFile.setImportedAt(System.currentTimeMillis());
        genericLogFile.setVersion(1);
    }

    public LogFile getLogFile() {
        return genericLogFile;
    }

    public Iterable <TypeDescription>  getTypeDescriptions() {
        Map <String, TypeDescription>  types = new TypeDescriptorParser()
                .parserTypeDescription();

        return types.values();
    }

    public void setContext(ImportContext context) {
        if (importContext != null) {
            throw new IllegalStateException("Can't import log twice!");
        }
        importContext = context;
        if (file != null) {
            throw new IllegalStateException(
                    "setContext should only be called once");
        }

        file = importContext.getFile();
        file = context.getFile();
        //
        genericLogFile = GenericLogFile.valueOf(file);
        genericLogFile.setImportedAt(System.currentTimeMillis());
        //
        if (!canRead(file)) {
            throw new ImportException("Invalid file format. " + toString()
                    + " can't read the file: " + file.getName() + " on path: "
                    + file.getAbsolutePath());
        }
    }

    public void close() throws IOException {
        if (logFileReader != null) {
            logFileReader.close();
        }
    }

    /**
     * Creates a log event from the given string. A log event always have a time
     * stamp, a reference to its log file and a log event type. Any number of
     * properties can be set to a generic log event using the addPropery method.
     * 
     * @param readLine
     *            string with event data
     * @return the created log event.
     */
    public GenericEventInfo createEventFromString(final String readLine) {
        GenericEventInfo event = null;
        Scanner s = new Scanner(readLine);
        s.findInLine(REGEXP);

        MatchResult result;
        try {
            result = s.match();
        } catch (final IllegalStateException e) {
            throw new ImportException("Unable to parse: " + readLine
                    + ", with regular expression" + REGEXP, e);
        }

        TimestampUtil tsu = new TimestampUtil();
        tsu.setYear(result.group(1));
        tsu.setMonth(result.group(2));
        tsu.setDay(result.group(3));
        tsu.setHour(result.group(4));
        tsu.setMinute(result.group(5));
        tsu.setSecond(result.group(6));
        tsu.setNs(result.group(7) + "000");

        String eventName = result.group(8);
        if (SYSTEM_INFO.equals(eventName)) {
            String params = result.group(9);
            event = createMessageEvent(params, tsu);
        } else if (TASK_SWITCH.equals(eventName)) {
            String params = result.group(9);
            event = createTaskSwitchEvent(params, tsu);
        } else if (SEND.equals(eventName)) {
            String params = result.group(9);
            event = createSendEvent(params, tsu);
        } else if (RECEIVE.equals(eventName)) {
            String params = result.group(9);
            event = createReceiveEvent(params, tsu);
        }

        return event;
    }

    /**
     * Creates a generic log event where the log event type (that is shown in
     * the GUI) is set to "LogMessage".
     * 
     * @param params
     *            contains the parameters to the log event that is returned.
     * @param tsu
     *            is the time stamp.
     * @return the created log event.
     */
    private GenericEventInfo createMessageEvent(final String params,
            final TimestampUtil tsu) {
        final Scanner s = new Scanner(params);
        MatchResult result;
        s.findInLine(SYSTEM_INFO_PARAMS);

        try {
            result = s.match();
        } catch (final IllegalStateException e) {
            throw new ImportException("Unable to parse: " + params
                    + ", with regular expression" + REGEXP, e);
        }
        GenericLogEvent event = new GenericLogEvent();
        event.setTs(tsu.getTs());
        event.addProperty("Message", result.group(1));

        event.setTypeName("LogMessage");
        event.setLogFile(genericLogFile);

        FieldValues values = new FieldValues();
        values.addStringValue(event.getProperty("Message").toString());
        GenericEventInfo eventInfo = new GenericEventInfo(event.getTs(), 1,
                values);
        /*
         * Add Message as a dynamic property
         */
        return eventInfo;
    }

    /**
     * Creates a generic task(/process) switch event where the log event type
     * (that is shown in the GUI) is set to TaskSwitch.
     * 
     * @param params
     *            contains the parameters to the log event that is returned.
     * @param tsu
     *            is the time stamp.
     * @return the created log event.
     */
    private GenericEventInfo createTaskSwitchEvent(final String params,
            final TimestampUtil tsu) {
        final Scanner s = new Scanner(params);
        s.findInLine(TASKSWITCH_PARAMS);
        MatchResult result;
        try {
            result = s.match();
        } catch (final IllegalStateException e) {
            throw new ImportException("Unable to parse: " + params
                    + ", with regular expression" + REGEXP, e);
        }
        GenericTask outTask = getArtifactByName(result.group(1));
        GenericTask inTask = getArtifactByName(result.group(2));

        FieldValues values = new FieldValues();
        GenericTask art = getArtifactByName(result.group(2));
        TaskArtifactInfo artifact = new TaskArtifactInfo(Integer.parseInt(art
                .getId()), art.getName(), TaskClass.PROCESS, art.getPriority(),
                5, values);
        artifactList.put(new Long(Integer.parseInt(art.getId())), artifact);

        GenericEventInfo eventInfo = new TaskSwitchEventInfo(tsu.getTs(),
                Integer.parseInt(inTask.getId()), Integer.parseInt(outTask
                        .getId()), 0, 2, values);

        return eventInfo;
    }

    /**
     * Creates a generic send event where the log event type (that is shown in
     * the GUI) is set to SendEvent.
     * 
     * @param params
     *            contains the parameters that are needed to create the send
     *            event: sender, receiver, signal
     * @param tsu
     *            is the time stamp.
     * @return the created log event.
     */
    private GenericEventInfo createSendEvent(final String params,
            final TimestampUtil tsu) {
        final Scanner s = new Scanner(params);
        s.findInLine(SEND_PARAMS);
        MatchResult result;
        try {
            result = s.match();
        } catch (final IllegalStateException e) {
            throw new ImportException("Unable to parse: " + params
                    + ", with regular expression" + REGEXP, e);
        }

        FieldValues values = new FieldValues();
        GenericTask gTask = getArtifactByName(result.group(1));
        TaskArtifactInfo artifact = new TaskArtifactInfo(Integer.parseInt(gTask
                .getId()), gTask.getName(), TaskClass.PROCESS, gTask
                .getPriority(), 5, values);
        artifactList.put(new Long(Integer.parseInt(gTask.getId())), artifact);
        GenericEventInfo eventInfo = new SendEventInfo(tsu.getTs(), Integer
                .parseInt(getArtifactByName(result.group(1)).getId()), Integer
                .parseInt(getArtifactByName(result.group(2)).getId()), tsu
                .getTs(), result.group(3), 3, values);
        return eventInfo;
    }

    /**
     * Creates a generic receive event where the log event type (that is shown
     * in the GUI) is set to ReceiveEvent.
     * 
     * @param params
     *            contains the parameters that are needed to create the receive
     *            event: sender, receiver, signal
     * @param tsu
     *            is the time stamp.
     * @return the created log event.
     */
    private GenericEventInfo createReceiveEvent(String params, TimestampUtil tsu) {
        final Scanner s = new Scanner(params);
        s.findInLine(RECEIVE_PARAMS);
        MatchResult result;
        try {
            result = s.match();
        } catch (final IllegalStateException e) {
            throw new ImportException("Unable to parse: " + params
                    + ", with regular expression" + REGEXP, e);
        }

        String recName = result.group(1);
        FieldValues values = new FieldValues();
        GenericTask gTask = getArtifactByName(result.group(1));
        TaskArtifactInfo artifact = new TaskArtifactInfo(Integer.parseInt(gTask
                .getId()), gTask.getName(), TaskClass.PROCESS, gTask
                .getPriority(), 5, values);

        artifactList.put(new Long(Integer.parseInt(gTask.getId())), artifact);
        GenericEventInfo eventInfo = new ReceiveEventInfo(tsu.getTs(), Integer
                .parseInt(getArtifactByName(recName).getId()), Integer
                .parseInt(getArtifactByName(recName).getId()), tsu.getTs(),
                result.group(2), 4, values);
        return eventInfo;
    }

    /**
     * Returns a artifact of the GenericTask type. If the task is already
     * created, the created is used, otherwise is a new created and returned.
     * Tasks are are used for the sequence diagram view and the Gantt diagram
     * view.
     * 
     * @param name
     *            is the name of the task
     * @return the already created task or a newly created and added one.
     */
    private GenericTask getArtifactByName(final String name) {
        GenericTask artifact = null;
        if (artifacts.containsKey(name)) {
            artifact = (GenericTask) artifacts.get(name);
        } else {
            artifact = new GenericTask();
            artifact.setLogFile(genericLogFile);
            artifact.setName(name);
            artifact.setTaskId(name.hashCode());
            artifact.setParent(getSequence());
            artifact = importContext.resolveArtifact(artifact);
            artifacts.put(name, artifact);
        }
        return artifact;
    }

    /**
     * Returns a sequence. If the sequence is already created, the created is
     * used, otherwise is a new created and returned. Sequences are are used for
     * the sequence diagram view. There can exist more than one sequence. When
     * opening a sequence diagram, the user have to specify what sequence to
     * show.
     * 
     * The artifacts that are created have to have a sequence to refer to.
     * 
     * @return the already created sequence or a newly created and added one.
     */
    private ISequence getSequence() {
        if (this.sequence == null) {
            this.sequence = new GenericSequence();
            this.sequence.setLogFile(genericLogFile);
            this.sequence.setRoot(true);
            this.sequence.setName("Sequence");
            this.sequence = importContext.resolveArtifact(sequence);
        }
        return this.sequence;
    }

    class StringElementIterator implements Iterator <GenericEventInfo>  {
        private LinkedList <GenericEventInfo>  cachedEvents;

        public StringElementIterator() {
            cachedEvents = new LinkedList <GenericEventInfo> ();

            /*
             * The next-method needs to know if there are more events. Caching
             * is the answer of this problem.
             */
            readEvent();
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            if (cachedEvents.size() >  0) {
                return true;
            }
            return false;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Iterator#next()
         */
        public GenericEventInfo next() {
            readEvent();
            GenericEventInfo first = (GenericEventInfo) cachedEvents.getFirst();
            cachedEvents.removeFirst();
            return first;
        }

        /**
         * Reads from the log file and creates an event. The event is put in the
         * cache.
         */
        private void readEvent() {
            GenericEventInfo readEvent = null;
            try {
                String readLine = logFileReader.readLine();
                while (readLine != null && readLine.length()  < 10) {
                    readLine = logFileReader.readLine();
                }
                if (readLine != null) {
                    readEvent = createEventFromString(readLine);
                }
            } catch (IOException e) {
                return;
            }

            if (readEvent != null) {
                cachedEvents.addLast(readEvent);
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class TypeDescriptorParser extends DefaultHandler {

        private String TYPE_DESC_XML_FILE = "SimpleTypeDescriptors.xml";

        private final Map <String, TypeDescription>  type;

        private String typeId;

        private String typeName;

        private String fieldName;

        private FieldType fieldType;

        private List <FieldDescription>  fieldList;

        private TypeDescription description;

        private FieldDescription fieldDescription;

        public TypeDescriptorParser() {
            type = new HashMap <String, TypeDescription> ();
            fieldList = new ArrayList <FieldDescription> ();
        }

        public Map <String, TypeDescription>  parserTypeDescription() {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            try {
                SAXParser sp = spf.newSAXParser();
                sp
                        .parse(
                                (ImporterActivatorPlugin.getBundlePath() + TYPE_DESC_XML_FILE),
                                this);
            } catch (SAXException se) {
                se.printStackTrace();
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            return type;
        }

        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("fieldDescription")) {
                fieldType = FieldType.fromId(Integer.parseInt(attributes
                        .getValue("type")));
                fieldName = attributes.getValue("name");
                fieldDescription = new FieldDescription(fieldName, fieldType, 0);
                fieldList.add(fieldDescription);
            }
            if (qName.equalsIgnoreCase("type")) {
                typeId = attributes.getValue("id");
                typeName = attributes.getValue("type-name");
                description = new TypeDescription(Integer.parseInt(typeId),
                        typeName, fieldList);
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("type")) {
                type
                        .put(Integer.toString(description.getTypeId()),
                                description);
                fieldList = new ArrayList <FieldDescription> ();
            }

        }
    }

}

