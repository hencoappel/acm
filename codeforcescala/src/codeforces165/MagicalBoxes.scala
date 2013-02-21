package codeforces165
import scala.collection.Set
import scala.collection.immutable.List

object MagicalBoxes extends App {

  val n = readInt //num tests
  var list:List[Array[Int]] = Nil
  
  for(i <- 0 until n){
    list = list :: readLine.split(' ').map(_.toInt)
  }
  
}
