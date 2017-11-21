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

case class Matrix4D(x1: VT,
                    y1: VT,
                    z1: VT,
                    w1: VT,
                    x2: VT,
                    y2: VT,
                    z2: VT,
                    w2: VT,
                    x3: VT,
                    y3: VT,
                    z3: VT,
                    w3: VT,
                    x4: VT,
                    y4: VT,
                    z4: VT,
                    w4: VT) {

  val p = List(
    List(x1, y1, z1, w1),
    List(x2, y2, z2, w2),
    List(x3, y3, z3, w3),
    List(x4, y4, z4, w4)
  )

  def +(m: Matrix4D) =
    Matrix4D(
      zipWith(p(0), m.p(0), add),
      zipWith(p(1), m.p(1), add),
      zipWith(p(2), m.p(2), add),
      zipWith(p(3), m.p(3), add)
    )
  def -(m: Matrix4D) =
    Matrix4D(
      zipWith(p(0), m.p(0), sub),
      zipWith(p(1), m.p(1), sub),
      zipWith(p(2), m.p(2), sub),
      zipWith(p(3), m.p(3), sub)
    )
  def *(v: Vector4D): Vector4D = {
    val vr = v.reset
    // TODO change dot
    Vector4D(vr dot4 p(0), vr dot4 p(1), vr dot4 p(2), vr dot4 p(3))
  }
  def *(m: Matrix4D): Matrix4D = {
    val l = for {
      i <- 0 to 3
      x <- 0 to 3
      y <- 0 to 3
    } yield m.p(i)(y) * p(x)(i)
    l.grouped(4).grouped(4).foldLeft(Matrix4D.empty()) {
      case (a, b) => a + Matrix4D(b)
    }
  }

  override def toString =
    "(" +
      "(" + x1 + ", " + y1 + ", " + z1 + ", " + w1 + ") " +
      "(" + x2 + ", " + y2 + ", " + z2 + ", " + w2 + ") " +
      "(" + x3 + ", " + y3 + ", " + z3 + ", " + w3 + ") " +
      "(" + x4 + ", " + y4 + ", " + z4 + ", " + w4 + ")" + ")"

  private def zipWith[A, B, C](a: List[A], b: List[B], f: (A, B) => C) =
    a zip b map f.tupled
  private def add(a: VT, b: VT) = a + b
  private def sub(a: VT, b: VT) = a - b
}

object Matrix4D {

  def empty(): Matrix4D =
    Matrix4D(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

  /** Identity matrix. */
  def apply(): Matrix4D =
    Matrix4D(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1)

  def apply(v1: Vector4D, v2: Vector4D, v3: Vector4D, v4: Vector4D): Matrix4D =
    apply(v1.p, v2.p, v3.p, v4.p)

  def apply(l: Seq[Seq[VT]]): Matrix4D =
    apply(l(0), l(1), l(2), l(3))

  def apply(l1: Seq[VT], l2: Seq[VT], l3: Seq[VT], l4: Seq[VT]): Matrix4D =
    Matrix4D(l1(0),
             l1(1),
             l1(2),
             l1(3),
             l2(0),
             l2(1),
             l2(2),
             l2(3),
             l3(0),
             l3(1),
             l3(2),
             l3(3),
             l4(0),
             l4(1),
             l4(2),
             l4(3))
}
