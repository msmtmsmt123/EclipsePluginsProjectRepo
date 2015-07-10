/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGStartProcess extends Message implements dbgserverinterfaceConstants{
   public int pid;


   public DBGStartProcess(int _pid) {
      pid = _pid;
   }

   public DBGStartProcess(DataInputStream _s) throws IOException { signalNo = 32976; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.pid);}
   public final static void write(DataOutputStream _s, int _pid   ) throws IOException {
         int _i;
         _s.writeInt(DBGSTARTPROCESS);
         int _size=12;
         _s.writeInt(_size);
         _s.writeInt(_pid);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         pid=_s.readInt();
   }
}