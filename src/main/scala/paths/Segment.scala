package paths

case class Segment(src: Point, des: Point) {
  def length: Double = {
    val dx = des.x - src.x
    val dy = des.y - src.y
    math.sqrt(dx*dx + dy*dy)
  }

  def stops: List[Point] =
    List(src, des)
}
