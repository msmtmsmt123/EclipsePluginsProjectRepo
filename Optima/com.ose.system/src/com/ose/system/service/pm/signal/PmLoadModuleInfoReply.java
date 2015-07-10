/* COPYRIGHT-ENEA-SRC-R2 *
 **************************************************************************
 * Copyright (C) 2007 by Enea Software AB.
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
package com.ose.system.service.pm.signal;

import java.io.IOException;
import com.ose.gateway.SignalInputStream;
import com.ose.gateway.SignalOutputStream;

public class PmLoadModuleInfoReply extends PmLoadModuleInfoReplySignal
{
   public static final int SIG_NO = 36217;
   
   public PmLoadModuleInfoReply()
   {
      super(SIG_NO);
   }
   
   protected void read(SignalInputStream in) throws IOException
   {
      status = in.readS32();
      install_handle = in.readString(32);
      entrypoint = in.readS32();
      options = in.readS32();
      text_base = in.readS32();
      text_size = in.readS32();
      data_base = in.readS32();
      data_size = in.readS32();
      no_of_sections = in.readS32();
      no_of_instances = in.readS32();
      file_format = in.readString(32);
      file_name = in.readString(256);
   }

   protected void write(SignalOutputStream out) throws IOException
   {
      out.writeS32(status);
      out.writeString(install_handle, 32);
      out.writeS32(PmUtils.longToInt(entrypoint));
      out.writeS32(options);
      out.writeS32(PmUtils.longToInt(text_base));
      out.writeS32(PmUtils.longToInt(text_size));
      out.writeS32(PmUtils.longToInt(data_base));
      out.writeS32(PmUtils.longToInt(data_size));
      out.writeS32(no_of_sections);
      out.writeS32(no_of_instances);
      out.writeString(file_format, 32);
      out.writeString(file_name, 256);
   }
}
