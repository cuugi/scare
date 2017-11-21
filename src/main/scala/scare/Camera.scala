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