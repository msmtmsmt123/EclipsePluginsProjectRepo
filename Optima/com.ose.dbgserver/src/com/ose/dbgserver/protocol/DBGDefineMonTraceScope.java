/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGDefineMonTraceScope extends Message implements dbgserverinterfaceConstants{
   public short count;
   public byte unused1;
   public byte unused2;
   public byte names[];


   public DBGDefineMonTraceScope(short _count, byte _unused1, byte _unused2, byte _names[]) {
      count = _count;
      unused1 = _unused1;
      unused2 = _unused2;
      names = _names;
   }

   public DBGDefineMonTraceScope(DataInputStream _s) throws IOException { signalNo = 32974; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.count, this.unused1, this.unused2, this.names);}
   public final static void write(DataOutputStream _s, short _count, byte _unused1, byte _unused2, byte _names[]   ) throws IOException {
         int _i;
         _s.writeInt(DBGDEFINEMONTRACESCOPE);
         int _size=12
            +4+_names.length
            ;
         _s.writeInt(_size);
         _s.writeShort(_count);
         _s.writeByte(_unused1);
         _s.writeByte(_unused2);
         int _dynSize=12;
         int _bytes2Skip;

         // write names
         _bytes2Skip=4-_dynSize&3;
         for(_i=0;_i<_bytes2Skip;_i++) _s.writeByte(0);
         _dynSize+=_bytes2Skip;
         _s.writeInt(_names.length);
         _dynSize+=_names.length;
         _s.write(_names);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         count=_s.readShort();
         unused1=_s.readByte();
         unused2=_s.readByte();
         int _dynSize=12;
         int _bytes2Skip;

         // read names
         _bytes2Skip=4-_dynSize&3;
         if(_bytes2Skip!=0) {_s.skipBytes(_bytes2Skip);_dynSize+=_bytes2Skip;}
         _size=_s.readInt();
         _dynSize+=_size;
         names=new byte[_size];
         _s.readFully(names,0,_size);
   }
}
