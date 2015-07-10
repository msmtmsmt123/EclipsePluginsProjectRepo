/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGGetProcMeasurementStatusReply extends Message implements dbgserverinterfaceConstants{
   public int measurementStatus;
   public int uInterval;
   public int currentTimeTick;
   public int currentTimeUTick;
   public byte procSpec[];


   public DBGGetProcMeasurementStatusReply(int _measurementStatus, int _uInterval, int _currentTimeTick, int _currentTimeUTick, byte _procSpec[]) {
      measurementStatus = _measurementStatus;
      uInterval = _uInterval;
      currentTimeTick = _currentTimeTick;
      currentTimeUTick = _currentTimeUTick;
      procSpec = _procSpec;
   }

   public DBGGetProcMeasurementStatusReply(DataInputStream _s) throws IOException { signalNo = 33003; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.measurementStatus, this.uInterval, this.currentTimeTick, this.currentTimeUTick, this.procSpec);}
   public final static void write(DataOutputStream _s, int _measurementStatus, int _uInterval, int _currentTimeTick, int _currentTimeUTick, byte _procSpec[]   ) throws IOException {
         int _i;
         _s.writeInt(DBGGETPROCMEASUREMENTSTATUSREPLY);
         int _size=24
            +4+_procSpec.length
            ;
         _s.writeInt(_size);
         _s.writeInt(_measurementStatus);
         _s.writeInt(_uInterval);
         _s.writeInt(_currentTimeTick);
         _s.writeInt(_currentTimeUTick);
         int _dynSize=24;
         int _bytes2Skip;

         // write procSpec
         _bytes2Skip=4-_dynSize&3;
         for(_i=0;_i<_bytes2Skip;_i++) _s.writeByte(0);
         _dynSize+=_bytes2Skip;
         _s.writeInt(_procSpec.length);
         _dynSize+=_procSpec.length;
         _s.write(_procSpec);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         measurementStatus=_s.readInt();
         uInterval=_s.readInt();
         currentTimeTick=_s.readInt();
         currentTimeUTick=_s.readInt();
         int _dynSize=24;
         int _bytes2Skip;

         // read procSpec
         _bytes2Skip=4-_dynSize&3;
         if(_bytes2Skip!=0) {_s.skipBytes(_bytes2Skip);_dynSize+=_bytes2Skip;}
         _size=_s.readInt();
         _dynSize+=_size;
         procSpec=new byte[_size];
         _s.readFully(procSpec,0,_size);
   }
}