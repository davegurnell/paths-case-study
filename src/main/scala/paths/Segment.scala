package paths

case class Segment(src: Point, des: Point) {
  def distance: Double = {
    val dx = des.x - src.x
    val dy = des.y - src.y
    math.sqrt(dx*dx + dy*dy)
  }
}
