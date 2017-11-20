package scare

case class Camera(location: Vector4D,
                  direction: Vector4D,
                  up: Vector4D,
                  aspectRatio: VT = 3.0 / 4.0,
                  fov: VT = math.Pi / 2,
                  nearPlane: VT = 0.1,
                  farPlane: VT = -1)
    extends Thing[Camera] {
  override def withLocation(l: Vector4D) = copy(location = l)
}

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
