/* COPYRIGHT-ENEA-SRC-R2 *
 **************************************************************************
 * Copyright (C) 2010 by Enea Software AB.
 * All rights reserved.
 *
 * This Software is furnished under a software license agreement and
 * may be used only in accordance with the terms of such agreement.
 * Any other use or reproduction is prohibited. No title to and
 * ownership of the Software is hereby transferred.
 *
 * PROPRIETARY NOTICE
 * This Software consists of confidential information.
 * Trade secret law and copyright law protect this Software.
 * The above notice of copyright on this Software does not indicate
 * any actual or intended publication of such Software.
 **************************************************************************
 * COPYRIGHT-END */

package com.ose.system.service.monitor.signal;

import java.io.IOException;
import com.ose.gateway.Signal;
import com.ose.gateway.SignalInputStream;
import com.ose.gateway.SignalOutputStream;

public class MonitorGetSegmentInfoLongReply extends Signal
{
   public static final int SIG_NO = 39020;

   public int sid;             // U32
   public int number;          // U32
   public int signalsAttached; // U32
   public boolean masMapped;   // U32
   public int reserved0;       // U32
   public String name;         // char[]

   public MonitorGetSegmentInfoLongReply()
   {
      super(SIG_NO);
   }

   protected void read(SignalInputStream in) throws IOException
   {
      sid = in.readS32();
      number = in.readS32();
      signalsAttached = in.readS32();
      masMapped = in.readBoolean();
      reserved0 = in.readS32(); // Unused U32 reserved0
      in.readS32(); // Unused U32 reserved1
      in.readS32(); // Unused U32 reserved2
      name = in.readString();
   }

   protected void write(SignalOutputStream out) throws IOException
   {
      out.writeS32(sid);
      out.writeS32(number);
      out.writeS32(signalsAttached);
      out.writeBoolean(masMapped);
      out.writeS32(reserved0); // Unused U32 reserved0
      out.writeS32(0); // Unused U32 reserved1
      out.writeS32(0); // Unused U32 reserved2
      out.writeString((name != null) ? name : "");
   }
}
