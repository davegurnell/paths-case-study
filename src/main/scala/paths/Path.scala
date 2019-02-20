package paths

case class Path(segments: List[Segment]) {
  def length: Double =
    segments.foldLeft(0.0)(_ + _.length)

  def isValid: Boolean =
    segments.sliding(2).forall { case Seq(s1, s2) => s1.des == s2.src }

  def stops: List[Point] =
    segments.flatMap(_.stops).distinct

  def stopsAt(point: Point) =
    stops.contains(point)
}

object Path {
  def apply(points: Point *): Path =
    Path(points.sliding(2).map { case Seq(a, b) => Segment(a, b) }.toList)

  def shortest(paths: List[Path]): Option[Path] =
    paths.sortBy(_.length).headOption

  def stoppingAt(paths: List[Path], point: Point): List[Path] =
    paths.filter(_.stopsAt(point))

  def stoppingAtAll(paths: List[Path], points: List[Point]): List[Path] =
    points.foldLeft(paths)(stoppingAt)

  def shortestStoppingAtAll(paths: List[Path], points: List[Point]): Option[Path] =
    shortest(stoppingAtAll(paths, points))
}
