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

class Matrix4D(x1: Double, y1: Double, z1: Double, w1: Double,
	       x2: Double, y2: Double, z2: Double, w2: Double,
	       x3: Double, y3: Double, z3: Double, w3: Double,
	       x4: Double, y4: Double, z4: Double, w4: Double) {

  val p = List(
    List(x1, y1, z1, w1),
    List(x2, y2, z2, w2),
    List(x3, y3, z3, w3),
    List(x4, y4, z4, w4)
  )

  def this() = this(1, 0, 0, 0,
		    0, 1, 0, 0,
		    0, 0, 1, 0,
		    0, 0, 0, 1)
  def this(l1: List[Double], l2: List[Double],
	   l3: List[Double], l4: List[Double]) =
    this(l1(0), l1(1), l1(2), l1(3),
	 l2(0), l2(1), l2(2), l2(3),
	 l3(0), l3(1), l3(2), l3(3),
	 l4(0), l4(1), l4(2), l4(3))

  def +(m: Matrix4D) =
    new Matrix4D(
      zipWith(p(0), m.p(0), add),
      zipWith(p(1), m.p(1), add),
      zipWith(p(2), m.p(2), add),
      zipWith(p(3), m.p(3), add)
    )
  def -(m: Matrix4D) =
    new Matrix4D(
      zipWith(p(0), m.p(0), sub),
      zipWith(p(1), m.p(1), sub),
      zipWith(p(2), m.p(2), sub),
      zipWith(p(3), m.p(3), sub)
    )
  def *(v: Vector4D) = {
    val vr = v.reset
      // TODO change dot
    new Vector4D(vr dot4 p(0),
		 vr dot4 p(1),
		 vr dot4 p(2),
		 vr dot4 p(3))
  }

  override def toString = "(" +
    "(" + x1 + ", " + y1 + ", " + z1 + ", " + w1 + ")" +
    "(" + x2 + ", " + y2 + ", " + z2 + ", " + w2 + ")" +
    "(" + x3 + ", " + y3 + ", " + z3 + ", " + w3 + ")" +
    "(" + x4 + ", " + y4 + ", " + z4 + ", " + w4 + ")" + ")"

  private def zipWith[A, B, C](a: List[A], b: List[B], f: (A, B) => C) =
    a zip b map f.tupled
  private def add(a: Double, b: Double) = a + b
  private def sub(a: Double, b: Double) = a - b
}
