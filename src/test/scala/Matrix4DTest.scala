import org.scalatest.FunSuite

import scare.{Vector4D, Matrix4D}

class Matrix4DTest extends FunSuite {

  val m1 = new Matrix4D
  val v1 = new Vector4D(1, 2, 3)

  test("*") {
    val m1v1 = m1 * v1
    assert(m1v1 === v1)
  }
}
