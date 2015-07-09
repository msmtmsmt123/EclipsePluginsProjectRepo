<!--
 | (C) Copyright IBM Corporation 2001, 2005. All Rights Reserved.
 |
 | The Darwin Information Typing Architecture (DITA) was orginated by
 | IBM's XML Workgroup and ID Workbench tools team.
 |
 | Refer to this file by the following public identfier or an appropriate
 | system identifier:
 |
 |   PUBLIC "-//IBM//ELEMENTS DITA Map Group Domain//EN"
 |
 | Release history (vrm):
 |   1.0.0 Initial release on developerWorks, March 2001 (dita00.zip)
 |   1.0.1 fix 1 on developerWorks, October 2001 (dita01.zip)
 |   1.0.2 consolidated redesign December 2001
 |   1.0.3 fix 1, dtd freeze for UCD-1 January 2002
 |   1.1.0 Release 1 March 2002 (dita10.zip)
 |   1.1.1 Release 1.1 December 2002
 |   1.1.2 Release 1.2 June 2003
 |   1.1.2 Release 1.2 March 2004: bug fixes
 |   1.1.2 Release 1.2 June 2003
 *-->

<!ENTITY % topichead   "topichead">
<!ENTITY % topicgroup  "topicgroup">

<!ELEMENT topichead ((%topicmeta;)?, (%topicref;|%navref;|%anchor;)*)>
<!ATTLIST topichead
  navtitle     CDATA     #REQUIRED
  id           ID        #IMPLIED
  conref       CDATA     #IMPLIED
  %topicref-atts;
  %select-atts;
>
<!ELEMENT topicgroup ((%topicmeta;)?, (%topicref;|%navref;|%anchor;)*)>
<!ATTLIST topicgroup
  id           ID        #IMPLIED
  conref       CDATA     #IMPLIED
  %topicref-atts;
  %select-atts;
>

<!ATTLIST topichead %global-atts; class CDATA "+ map/topicref mapgroup/topichead ">
<!ATTLIST topicgroup %global-atts; class CDATA "+ map/topicref mapgroup/topicgroup ">
