/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGSingleStep extends Message implements dbgserverinterfaceConstants{
   public int eventMask;


   public DBGSingleStep(int _eventMask) {
      eventMask = _eventMask;
   }

   public DBGSingleStep(DataInputStream _s) throws IOException { signalNo = 32987; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.eventMask);}
   public final static void write(DataOutputStream _s, int _eventMask   ) throws IOException {
         int _i;
         _s.writeInt(DBGSINGLESTEP);
         int _size=12;
         _s.writeInt(_size);
         _s.writeInt(_eventMask);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         eventMask=_s.readInt();
   }
}