/* COPYRIGHT-ENEA-SRC-R2 *
 **************************************************************************
 * Copyright (C) 2005-2007 by Enea Software AB.
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

package com.ose.cdt.debug.mi.core.command;

import org.eclipse.cdt.debug.mi.core.command.CLICommand;

/*
 * add-ose-load-module <file> <install-handle>
 */
public class CLIAddLoadModule extends CLICommand
{
   public CLIAddLoadModule(String file, String installHandle)
   {
      super("add-ose-load-module " + file + " " + installHandle);
   }
}
