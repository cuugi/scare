/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * Scare - Scala rendering engine
 * Copyright (c) 2013-2017 cuugi(a)iki.fi
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

package scare

import scala.math._

case class Vector4D(x: Double, y: Double, z: Double, w: Double = 1.0) {
  val p = List(x, y, z, w)

  def this(l: List[Double]) =
    this(l(0), l(1), l(2), l(3))

  def length = sqrt(x * x + y * y + z * z) * w
  def normalize = new Vector4D(x, y, z, w / length)
  def isUnit = (length == 1.0)
  def reset = new Vector4D(x * w, y * w, z * w)

  def *(m: Int) = new Vector4D(x, y, z, w * m)
  def /(d: Int) = new Vector4D(x, y, z, w / d)

  def +(v: Vector4D) = {
    val s = w / v.w
    new Vector4D(x + v.x / s, y + v.y / s, z + v.z / s, w)
  }
  def -(v: Vector4D) = {
    val s = w / v.w
    new Vector4D(x - v.x / s, y - v.y / s, z - v.z / s, w)
  }
  def unary_- = new Vector4D(-x, -y, -z, w)

  // |a||b|cos(a, b)
  def dot(v: Vector4D) = dot3(v)
  def dot(l: List[Double]) = dot3(l)
  def dot3(v: Vector4D) = w * v.w * (x * v.x + y * v.y + z * v.z)
  def dot3(l: List[Double]): Double = dot(new Vector4D(l))
  def dot4(v: Vector4D) = x * v.z + y * v.y + z * v.z + w * v.w
  def dot4(l: List[Double]): Double = dot4(new Vector4D(l))

  def cross(v: Vector4D) = {
    val s = w * v.w
    new Vector4D(s * (y * v.z - z * v.y),
                 s * (z * v.x - x * v.z),
                 s * (x * v.y - y * v.x))
  }

  override def toString = "(" + x + ", " + y + ", " + z + ", " + w + ")"

  override def equals(o: scala.Any): Boolean =
    o match {
      case v: Vector4D => v.x == x && v.y == y && v.z == z && v.w == w
      case _           => false
    }
}
