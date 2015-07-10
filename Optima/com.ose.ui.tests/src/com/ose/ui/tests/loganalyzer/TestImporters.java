/* COPYRIGHT-ENEA-SRC-R2 *
 **************************************************************************
 * Copyright (C) 2010 by Enea Software AB.
 * All rights reserved.
 *
 * This Software is furnished under a software license agreement and
 * may be used only in accordance with the terms of such agreement.
 * Any other use or reproduction is prohibited. No title to and
 * ownership of the Software is hereby transferred.
 *
 * PROPRIETARY NOTICE
 * This Software consists of confidential information.
 * Trade secret law and copyright law protect this Software.
 * The above notice of copyright on this Software does not indicate
 * any actual or intended publication of such Software.
 **************************************************************************
 * COPYRIGHT-END */

package com.ose.ui.tests.loganalyzer;

import com.ose.ui.tests.AbstractLABaseTest;
import com.ose.ui.tests.utils.LogAnalyzerUtil;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.swt.locator.TreeItemLocator;
import com.windowtester.runtime.swt.locator.eclipse.ViewLocator;

public class TestImporters extends AbstractLABaseTest
{
   private static final String PROJECT_NAME = "Project_1";

   private static final String PROJECT_NAME_2 = "Project_2";

   protected void oneTimeSetup() throws Exception
   {
      super.oneTimeSetup();

      LogAnalyzerUtil.createLogAnalyzerProject(PROJECT_NAME, getUI());
   }

   protected void setUp() throws Exception
   {
      super.setUp();
   }

   protected void tearDown() throws Exception
   {
      super.tearDown();
   }

   protected void oneTimeTearDown() throws Exception
   {
      super.oneTimeTearDown();

      LogAnalyzerUtil.deleteProject(PROJECT_NAME, getUI());
      LogAnalyzerUtil.deleteProject(PROJECT_NAME_2, getUI());
   }

   /**
    * Test Importer with different log files.
    * 
    * @throws Exception
    */
   public void testImporters() throws Exception
   {
      IUIContext ui = getUI();

      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME, "logset",
            "OSEdelta.pmd", ui);
      ui.click(2, new TreeItemLocator(PROJECT_NAME + "/" + "logset",
            new ViewLocator(LogAnalyzerUtil.SYSTEM_NAVIGATOR_VIEW_ID)));
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME, "logset",
            "OSEck.pmd", ui);
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME, "logset",
            "OSEdelta.event", ui);
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME, "logset",
            "sendreceive.event", ui);
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME, "logset",
            "printouts.log", ui);
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME, "logset",
            "BlackBoxRecorder.srl", ui);

      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME, "logset",
            "OSEdelta.pmd", ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME, "logset", "OSEck.pmd",
            ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME, "logset",
            "OSEdelta.event", ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME, "logset",
            "sendreceive.event", ui);
      //LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME, "logset",
      //      "printouts.log", ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME, "logset",
            "BlackBoxRecorder.srl", ui);
   }

   /**
    * Test Old and new Importers.
    * 
    * @throws Exception
    */
   public void testImportOperation() throws Exception
   {
      IUIContext ui = getUI();

      ui.click(1, new TreeItemLocator(PROJECT_NAME ,
            new ViewLocator("com.zealcore.se.ui.views.SystemNavigator")));
      ui.keyClick(WT.CR);
      LogAnalyzerUtil.createLogAnalyzerProject(PROJECT_NAME_2, getUI());
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME_2, "logset",
            "BlackBoxRecorder.srl", ui);
      ui.click(2, new TreeItemLocator(PROJECT_NAME_2 + "/" + "logset",
            new ViewLocator(LogAnalyzerUtil.SYSTEM_NAVIGATOR_VIEW_ID)));
      LogAnalyzerUtil.importLogfile(getLogfilePath(), PROJECT_NAME_2, "logset",
            "OSEdelta.pmd", ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME_2, "logset",
            "BlackBoxRecorder.srl", ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME_2, "logset",
            "OSEdelta.pmd", ui);

      LogAnalyzerUtil.configureLogfile(PROJECT_NAME_2, "logset",
            "OSEdelta.pmd", ui);
      LogAnalyzerUtil.configureLogfile(PROJECT_NAME_2, "logset",
            "BlackBoxRecorder.srl", ui);

      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME_2, "logset",
            "BlackBoxRecorder.srl", ui);
      LogAnalyzerUtil.deconfigureLogfile(PROJECT_NAME_2, "logset",
            "OSEdelta.pmd", ui);
   }
}
