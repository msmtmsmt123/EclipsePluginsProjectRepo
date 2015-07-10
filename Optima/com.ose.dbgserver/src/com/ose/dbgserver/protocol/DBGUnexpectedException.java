/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGUnexpectedException extends Message implements dbgserverinterfaceConstants{
   public int exceptionCode;
   public int faultAddress;
   public int pid;
   public String message;


   public DBGUnexpectedException(int _exceptionCode, int _faultAddress, int _pid, String _message) {
      exceptionCode = _exceptionCode;
      faultAddress = _faultAddress;
      pid = _pid;
      message = _message;
   }

   public DBGUnexpectedException(DataInputStream _s) throws IOException { signalNo = 33057; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.exceptionCode, this.faultAddress, this.pid, this.message);}
   public final static void write(DataOutputStream _s, int _exceptionCode, int _faultAddress, int _pid, String _message   ) throws IOException {
         int _i;
         int _messageSize=_message.length()+1;
         _s.writeInt(DBGUNEXPECTEDEXCEPTION);
         int _size=20
            +4+_messageSize
            ;
         _s.writeInt(_size);
         _s.writeInt(_exceptionCode);
         _s.writeInt(_faultAddress);
         _s.writeInt(_pid);
         int _dynSize=20;
         int _bytes2Skip;

         // write message
         _bytes2Skip=4-_dynSize&3;
         for(_i=0;_i<_bytes2Skip;_i++) _s.writeByte(0);
         _dynSize+=_bytes2Skip;
         _s.writeInt(_messageSize);
         _dynSize+=_messageSize;
         _s.writeBytes(_message);
         _s.writeByte(0);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         exceptionCode=_s.readInt();
         faultAddress=_s.readInt();
         pid=_s.readInt();
         int _dynSize=20;
         int _bytes2Skip;

         // read message
         _bytes2Skip=4-_dynSize&3;
         if(_bytes2Skip!=0) {_s.skipBytes(_bytes2Skip);_dynSize+=_bytes2Skip;}
         _size=_s.readInt();
         _dynSize+=_size;
         byte _message[] = new byte[_size];
         _s.readFully(_message, 0, _size);
         message=new String(_message, 0,0, _message.length-1);
   }
}
