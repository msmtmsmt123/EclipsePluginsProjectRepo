/*
     This module was generated automatically from /vobs/ose5/core_ext/dbgserver/private/dbgserverinterface.stl.
                DO NOT EDIT THIS FILE
*/



package com.ose.dbgserver.protocol;
import java.io.*;

public class DBGSetPriMeasurementStatus extends Message implements dbgserverinterfaceConstants{
   public int measurementStatus;
   public int uInterval;


   public DBGSetPriMeasurementStatus(int _measurementStatus, int _uInterval) {
      measurementStatus = _measurementStatus;
      uInterval = _uInterval;
   }

   public DBGSetPriMeasurementStatus(DataInputStream _s) throws IOException { signalNo = 33000; read(_s);}
   public final void sendMessage(DataOutputStream _s) throws IOException { write(_s, this.measurementStatus, this.uInterval);}
   public final static void write(DataOutputStream _s, int _measurementStatus, int _uInterval   ) throws IOException {
         int _i;
         _s.writeInt(DBGSETPRIMEASUREMENTSTATUS);
         int _size=16;
         _s.writeInt(_size);
         _s.writeInt(_measurementStatus);
         _s.writeInt(_uInterval);
   }
   public final void read(DataInputStream _s) throws IOException {
         int _i;
         int _size=_s.readInt();
         measurementStatus=_s.readInt();
         uInterval=_s.readInt();
   }
}
