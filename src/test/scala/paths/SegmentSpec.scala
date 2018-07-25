package paths

import org.scalatest._

class SegmentSpec extends FlatSpec with Matchers {
  "a segment" should "know its length" in {
    val a = Point(1.0, 1.0)
    val b = Point(4.0, 5.0)
    val s = Segment(a, b)

    s.length should equal(5.0 +- 0.001)
  }
}
