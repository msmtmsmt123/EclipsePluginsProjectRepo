/* COPYRIGHT-ENEA-SRC-R1 *
 **************************************************************************
 * Copyright (C) 2008 by Enea Software AB.
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

import com.ose.system.service.monitor.MonitorTag;

public class MonitorSetTimeoutActionpointRequest
   extends MonitorEventActionpointInfoSignal
{
   public static final int SIG_NO = 39294;

   public MonitorSetTimeoutActionpointRequest()
   {
      super(SIG_NO);
   }

   public MonitorSetTimeoutActionpointRequest(int state,
                                              int fromType,
                                              int fromId,
                                              int toType,
                                              int toId,
                                              boolean not,
                                              int action,
                                              int interceptType,
                                              int interceptId,
                                              int parameter,
                                              int client,
                                              int id,
                                              int count,
                                              MonitorTag[] tags)
   {
      super(SIG_NO,
            state,
            fromType,
            fromId,
            toType,
            toId,
            not,
            action,
            interceptType,
            interceptId,
            parameter,
            client,
            id,
            count,
            tags);
   }
}
