/* COPYRIGHT-ENEA-SRC-R1 *
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

package com.ose.chart.ui;

/**
 * A camera using a 2D orthographic projection.
 */
class OrthoCamera implements Camera
{
   public void applyProjectionTransform(GraphicsContext g, int width, int height)
   {
      g.setParallelProjection(0, width, 0, height);
   }

   public void applyWorldViewTransform(GraphicsContext g, int width, int height)
   {
      g.loadIdentityTransform();
   }   
}