package paths

import org.scalatest._

class SegmentSpec extends FlatSpec with Matchers {
  val p1 = Point(0, 0)
  val p2 = Point(0, 1)
  val p3 = Point(1, 0)
  val p4 = Point(1, 1)
  val p5 = Point(4, 5)

  "segment.distance" should "calculate the distance" in {
    Segment(p1, p2).distance should equal(1.0 +- 0.001)
    Segment(p4, p5).distance should equal(5.0 +- 0.001)
  }

  "segment.stops" should "return the start and the end" in {
    Segment(p1, p2).stops should equal(List(p1, p2))
    Segment(p4, p5).stops should equal(List(p4, p5))
  }
}
