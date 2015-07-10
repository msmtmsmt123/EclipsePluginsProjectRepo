/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGTraceCreateKillReply extends Message implements dbgserverinterfaceConstants{
   public int traceEntry;
   public int tick;
   public int utick;
   public int abstime;
   public int abstick;
   public short type;
   public short procType;
   public int pid;
   public String name;


   public DBGTraceCreateKillReply(int _traceEntry, int _tick, int _utick, int _abstime, int _abstick, short _type, short _procType, int _pid, String _name) {
      traceEntry = _traceEntry;
      tick = _tick;
      utick = _utick;
      abstime = _abstime;
      abstick = _abstick;
      type = _type;
      procType = _procType;
      pid = _pid;
      name = _name;
   }

   public DBGTraceCreateKillReply(DataInputStream _s) throws IOException { signalNo = 32940; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.traceEntry, this.tick, this.utick, this.abstime, this.abstick, this.type, this.procType, this.pid, this.name);}
   public final static void write(DataOutputStream _s, int _traceEntry, int _tick, int _utick, int _abstime, int _abstick, short _type, short _procType, int _pid, String _name   ) throws IOException {
         int _i;
         int _nameSize=_name.length()+1;
         _s.writeInt(DBGTRACECREATEKILLREPLY);
         int _size=36
            +4+_nameSize
            ;
         _s.writeInt(_size);
         _s.writeInt(_traceEntry);
         _s.writeInt(_tick);
         _s.writeInt(_utick);
         _s.writeInt(_abstime);
         _s.writeInt(_abstick);
         _s.writeShort(_type);
         _s.writeShort(_procType);
         _s.writeInt(_pid);
         int _dynSize=36;
         int _bytes2Skip;

         // write name
         _bytes2Skip=4-_dynSize&3;
         for(_i=0;_i<_bytes2Skip;_i++) _s.writeByte(0);
         _dynSize+=_bytes2Skip;
         _s.writeInt(_nameSize);
         _dynSize+=_nameSize;
         _s.writeBytes(_name);
         _s.writeByte(0);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         traceEntry=_s.readInt();
         tick=_s.readInt();
         utick=_s.readInt();
         abstime=_s.readInt();
         abstick=_s.readInt();
         type=_s.readShort();
         procType=_s.readShort();
         pid=_s.readInt();
         int _dynSize=36;
         int _bytes2Skip;

         // read name
         _bytes2Skip=4-_dynSize&3;
         if(_bytes2Skip!=0) {_s.skipBytes(_bytes2Skip);_dynSize+=_bytes2Skip;}
         _size=_s.readInt();
         _dynSize+=_size;
         byte _name[] = new byte[_size];
         _s.readFully(_name, 0, _size);
         name=new String(_name, 0,0, _name.length-1);
   }
}
