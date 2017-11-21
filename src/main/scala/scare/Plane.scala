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

case class Plane(location: Vector4D, transformation: Matrix4D, normal: Vector4D)
    extends Thing[Plane]
    with Object[Plane] {

  override def withLocation(l: Vector4D) = copy(location = l)

  override def withTransformation(t: Matrix4D) = copy(transformation = t)

}
