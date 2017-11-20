package scare

import org.scalatest.FunSuite

class Vector4DTest extends FunSuite {

  val v1 = new Vector4D(1, 2, 3)
  val v2 = new Vector4D(2, 2, -1)
  val v3 = new Vector4D(1, 0, 0, 2)
  val v4 = new Vector4D(0, 1, 0)

  test("+") {
    val v12 = v1 + v2
    val v23 = v2 + v3
    assert(v12 === new Vector4D(3, 4, 2))
    assert(v23 === new Vector4D(4, 2, -1))
  }

  test("-") {
    val v12 = v1 - v2
    val v23 = v2 - v3
    assert(v12 === new Vector4D(-1, 0, 4))
    assert(v23 === new Vector4D(0, 2, -1))
  }

  test("*") {
    val v14 = v1 * 4
    val v21 = v2 * -1
    assert(v14 === new Vector4D(1, 2, 3, 4))
    assert(v21.reset === -v2)
  }

  test("/") {
    val v12 = v1 / 2
    assert(v12.reset === new Vector4D(0.5, 1, 1.5))
  }

  test("dot") {
    val v1v4 = v1 dot v4
    val v3v4 = v3 dot v4
    assert(v1v4 === 2)
    assert(v3v4 === 0)
  }

  test("cross") {
    val v1v3 = v1 cross v3
    val v3v4 = v3 cross v4
    assert(v1v3 === new Vector4D(0, 6, -4))
    assert(v3v4 === new Vector4D(0, 0, 2))
  }
}
