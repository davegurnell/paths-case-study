package paths

import org.scalatest._

class PathSpec extends FlatSpec with Matchers {
  val p1 = Point(0, 0)
  val p2 = Point(0, 1)
  val p3 = Point(1, 0)
  val p4 = Point(1, 1)
  val p5 = Point(4, 5)

  "path.distance" should "calculate a distance" in {
    Path(p1, p2, p4, p5).distance should equal(7.0 +- 0.001)
  }

  "path.stops" should "enumerate the stops" in {
    Path(p1, p2, p4, p5).stops should equal(List(p1, p2, p4, p5))
  }

  "path.stopsAt" should "identify stops along the path" in {
    val path = Path(p1, p2, p4, p5)

    for(p <- List(p1, p2, p4, p5)) {
      path.stopsAt(p) should equal(true)
    }

    path.stopsAt(Point(1, 0)) should equal(false)
  }

  "path.isValid" should "determine whether adjacent segments meet one another" in {
    val s1 = Segment(Point(0, 0), Point(0, 1))
    val s2 = Segment(Point(0, 1), Point(1, 0))
    val s3 = Segment(Point(1, 0), Point(4, 4))

    Path(List(s1, s2, s3)).isValid should equal(true)
    Path(List(s1, s3, s2)).isValid should equal(false)
  }

  "Path.shortest" should "find the shortest path by distance" in {
    val path1 = Path(p1, p2, p3)
    val path2 = Path(p1, p2, p4)
    val path3 = Path(p1, p4, p1)

    Path.shortest(List(path1, path2, path3)) should equal(Some(path2))
  }

  "Path.stoppingAt" should "find paths that stop at a point" in {
    val path1 = Path(p1, p2, p3)
    val path2 = Path(p1, p2, p4)
    val path3 = Path(p1, p4, p1)
    val paths = List(path1, path2, path3)

    Path.stoppingAt(paths, p1) should equal(paths)
    Path.stoppingAt(paths, p2) should equal(List(path1, path2))
    Path.stoppingAt(paths, p3) should equal(List(path1))
    Path.stoppingAt(paths, p4) should equal(List(path2, path3))
    Path.stoppingAt(paths, Point(5, 5)) should equal(Nil)
  }

  "Path.stoppingAtAll" should "find paths that stop at all points" in {
    val path1 = Path(p1, p2, p3)
    val path2 = Path(p1, p2, p4)
    val path3 = Path(p1, p4, p1)
    val paths = List(path1, path2, path3)

    Path.stoppingAtAll(paths, List(p1, p2)) should equal(List(path1, path2))
    Path.stoppingAtAll(paths, List(p1, p4)) should equal(List(path2, path3))
    Path.stoppingAtAll(paths, List(p1, p3, p4)) should equal(Nil)
  }

  "Path.shortestStoppingAtAll" should "find paths that stop at all points" in {
    val path1 = Path(p1, p2, p3)
    val path2 = Path(p1, p2, p4)
    val path3 = Path(p1, p4, p1)
    val paths = List(path1, path2, path3)

    Path.shortestStoppingAtAll(paths, List(p1, p2)) should equal(Some(path2))
    Path.shortestStoppingAtAll(paths, List(p1, p4)) should equal(Some(path2))
    Path.shortestStoppingAtAll(paths, List(p1, p3, p4)) should equal(None)
  }
}
