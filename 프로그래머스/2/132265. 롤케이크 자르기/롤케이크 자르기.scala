import scala.collection.mutable

object Solution {
    def solution(topping: Vector[Int]): Int = {
        var right = topping.groupBy(identity).map(n => n._1 -> n._2.size)
        var left = Map[Int, Int]()
        topping.foldLeft(0) {(acc, num) =>
            left = left.updatedWith(num) {
                case Some(value) => Some(value + 1)
                case _ => Some(1)}
            right.get(num) match {
                case Some(value) => 
                    if (value == 1) right = right.removed(num)
                    else right = right.updated(num, value - 1)}
            if (left.size == right.size) acc + 1
            else acc
        }
    }
}