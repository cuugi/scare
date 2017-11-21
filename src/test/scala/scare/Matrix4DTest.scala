package scare

import org.scalatest.FunSuite

class Matrix4DTest extends FunSuite {

  val m1 = Matrix4D()
  val m2 = Matrix4D(1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2, 0, 1)
  val m3 = Matrix4D(1, 0, 2, 0, 2, 2, 3, 0, 0, 1, 0, 1, 0, 0, 0, 1)
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

  test("**") {
    val m1m1 = m1 * m1
    val m1m2 = m1 * m2
    val m2m3 = m2 * m3
    val m23 = Matrix4D(5, 4, 8, 0, 0, 0, 0, 0, 0, 1, 0, 1, 5, 4, 8, 1)
    assert(m1m1 === m1)
    assert(m1m2 === m2)
    assert(m2m3 === m23)
  }
}
