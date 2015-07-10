/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGFlowControl extends Message implements dbgserverinterfaceConstants{
   public int increment;


   public DBGFlowControl(int _increment) {
      increment = _increment;
   }

   public DBGFlowControl(DataInputStream _s) throws IOException { signalNo = 32907; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.increment);}
   public final static void write(DataOutputStream _s, int _increment   ) throws IOException {
         int _i;
         _s.writeInt(DBGFLOWCONTROL);
         int _size=12;
         _s.writeInt(_size);
         _s.writeInt(_increment);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         increment=_s.readInt();
   }
}
