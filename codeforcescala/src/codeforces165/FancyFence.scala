package codeforces165

object FancyFence extends App {

  val t = readInt //num tests

  for (i <- Range(0, t)) {
    checkAngle(readDouble)
  }

  def checkAngle(angle: Double) {
    val sides = 2 / (1 - (angle / 180))
    if (Math.abs(sides - Math.round(sides)) < 0.000000001) {
      println("YES")
    } else {
      println("NO")
    }
  }

}
