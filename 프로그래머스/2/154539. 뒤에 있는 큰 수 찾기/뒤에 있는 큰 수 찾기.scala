object Solution {
    def solution(numbers: Vector[Int]): Vector[Int] = {
        func(numbers.zipWithIndex, Vector.empty, Vector.fill(numbers.size)(-1))
    }
    
    def func(v: Vector[(Int, Int)], r: Vector[(Int, Int)], k: Vector[Int]): Vector[Int] = {
        if (v.isEmpty) k
        else if (r.isEmpty) func(v.tail, r.appended(v.head), k)
        else if(v.head._1 > r.last._1) func(v, r.dropRight(1), k.updated(r.last._2, v.head._1))
        else func(v.tail, r.appended(v.head), k)
  }
}