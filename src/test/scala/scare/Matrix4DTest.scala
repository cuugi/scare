package scare

import org.scalatest.FunSuite

class Matrix4DTest extends FunSuite {

  val m1 = Matrix4D()
  val v1 = Vector4D(1, 2, 3)

  test("+") {
    val m2 = m1 + m1
    assert(m2 === Matrix4D(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2))
  }

  test("-") {
    val m0 = m1 - m1
    assert(m0 === Matrix4D(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
  }

  test("*") {
    val m1v1 = m1 * v1
    assert(m1v1 === v1)
  }
}
