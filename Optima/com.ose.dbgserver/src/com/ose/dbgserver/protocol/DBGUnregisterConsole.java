/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGUnregisterConsole extends Message implements dbgserverinterfaceConstants{


   public DBGUnregisterConsole() {
   }

   public DBGUnregisterConsole(DataInputStream _s) throws IOException { signalNo = 33055; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s);}
   public final static void write(DataOutputStream _s   ) throws IOException {
         int _i;
         _s.writeInt(DBGUNREGISTERCONSOLE);
         int _size=8;
         _s.writeInt(_size);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
   }
}
