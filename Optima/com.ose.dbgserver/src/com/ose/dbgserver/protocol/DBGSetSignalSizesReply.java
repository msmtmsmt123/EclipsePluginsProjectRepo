/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGSetSignalSizesReply extends Message implements dbgserverinterfaceConstants{
   public int status;
   public int currentMaxTraceSize;
   public int currentMaxLinkSize;


   public DBGSetSignalSizesReply(int _status, int _currentMaxTraceSize, int _currentMaxLinkSize) {
      status = _status;
      currentMaxTraceSize = _currentMaxTraceSize;
      currentMaxLinkSize = _currentMaxLinkSize;
   }

   public DBGSetSignalSizesReply(DataInputStream _s) throws IOException { signalNo = 32910; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.status, this.currentMaxTraceSize, this.currentMaxLinkSize);}
   public final static void write(DataOutputStream _s, int _status, int _currentMaxTraceSize, int _currentMaxLinkSize   ) throws IOException {
         int _i;
         _s.writeInt(DBGSETSIGNALSIZESREPLY);
         int _size=20;
         _s.writeInt(_size);
         _s.writeInt(_status);
         _s.writeInt(_currentMaxTraceSize);
         _s.writeInt(_currentMaxLinkSize);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         status=_s.readInt();
         currentMaxTraceSize=_s.readInt();
         currentMaxLinkSize=_s.readInt();
   }
}