/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGStepProcessReply extends Message implements dbgserverinterfaceConstants{
   public int status;


   public DBGStepProcessReply(int _status) {
      status = _status;
   }

   public DBGStepProcessReply(DataInputStream _s) throws IOException { signalNo = 33036; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.status);}
   public final static void write(DataOutputStream _s, int _status   ) throws IOException {
         int _i;
         _s.writeInt(DBGSTEPPROCESSREPLY);
         int _size=12;
         _s.writeInt(_size);
         _s.writeInt(_status);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         status=_s.readInt();
   }
}
