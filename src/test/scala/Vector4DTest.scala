import org.scalatest.FunSuite

import scare.Vector4D;

class Vector4DTest extends FunSuite {

  val v1 = new Vector4D(1, 2, 3)
  val v2 = new Vector4D(2, 2, -1)
  val v3 = new Vector4D(1, 0, 0, 2)

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

}
