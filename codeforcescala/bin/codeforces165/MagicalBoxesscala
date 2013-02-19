package codeforces165
import scala.collection.Set

object Multithreading extends App {

  val t = readInt //num tests
  val threads = readLine.split(' ').map(_.toInt)

  var i = t - 1;
  while (i > 0 && threads(i) > threads(i - 1)) {
    i -= 1
  }
  println(i)
}
