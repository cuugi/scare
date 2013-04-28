/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * Scare - Scala rendering engile
 * Copyright (c) 2013 cuugi(a)iki.fi
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 *
 */

package scare;

import math._;

class Vector4D(x: Double, y: Double, z: Double, w: Double) {
  require(w != 0)

  val p = List(x, y, z, w)

  def this(x: Double, y: Double, z: Double) =
    this(x, y, z, 1)
  def this(l: List[Double]) =
    this(l(0), l(1), l(2), l(3))

  def length = sqrt(x*x + y*y + z*z) * w
  def normalize = new Vector4D(x, y, z, w/length)
  def isUnit = (length == 1.0)
  def reset = new Vector4D(x * w, y * w, z * w)

  def *(m: Int) = new Vector4D(x, y, z, w * m)
  def /(d: Int) = new Vector4D(x, y, z, w / d)

  def +(v: Vector4D) = {
    val s = w / v.p(3)
    new Vector4D(x + v.p(0) / s, y + v.p(1) / s, z + v.p(2) / s, w)
  }
  def -(v: Vector4D) = {
    val s = w / v.p(3)
    new Vector4D(x - v.p(0) / s, y - v.p(1) / s, z - v.p(2) / s, w)
  }

  // |a||b|cos(a, b)
  def dot(v: Vector4D) = {
    val s = w * v.p(3)
    s * (x * v.p(0) + y * v.p(1) + z * v.p(2))
  }
  def dot(l: List[Double]): Double = {
    dot(new Vector4D(l))
  }
  def cross(v: Vector4D) = {
    val s = w * v.p(3)
    new Vector4D(s * (p(1) * v.p(2) - p(2) * v.p(1)),
		 s * (p(2) * v.p(0) - p(0) * v.p(2)),
		 s * (p(0) * v.p(1) - p(1) * v.p(0)));
  }

  override def toString = "(" + x + ", " + y + ", " + z + ", " + w + ")"
}
