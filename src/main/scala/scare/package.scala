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

package object scare {
  type VT = Double

  trait Thing[T] {
    val location: Vector4D

    def withLocation(l: Vector4D): T
    def translate(v: Vector4D): T = this.withLocation(location + v)
  }

  trait Object[T] {
    val transformation: Matrix4D

    def withTransformation(t: Matrix4D): T
    def rotate(angle: VT, v: Vector4D): T =
      this.withTransformation(transformation * rotationMatrix(angle, v))

    protected def rotationMatrix(angle: VT, v: Vector4D): Matrix4D = {
      val a = 1 - Math.cos(angle)
      val b = Math.sin(angle)

      val l1 = List(1 + a * (v.x * v.x - 1),
                    a * v.x * v.y - v.z * b,
                    a * v.x * v.z + v.y * b,
                    0)
      val l2 = List(a * v.x * v.y + v.z * b,
                    1 + a * (v.y * v.y - 1),
                    a * v.y * v.z - v.x * b,
                    0)
      val l3 = List(a * v.x * v.z - v.y * b,
                    a * v.y * v.z + v.x * b,
                    1 + a * (v.z * v.z - 1),
                    0)
      val l4 = List(0, 0, 0, 1.0)
      Matrix4D(l1, l2, l3, l4)
    }
  }

}
