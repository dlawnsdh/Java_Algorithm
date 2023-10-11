import scala.io.StdIn

object Main {
    def main(args: Array[String]): Unit = {
        val nk = StdIn.readLine.split(" ").map(_.toInt)
        var arr = List[Int]()
        for (i <- 1 to nk(0)) {
          val m = StdIn.readInt
          arr = arr :+ m
        }

        val result = arr.sorted.reverse
            .foldLeft((nk(1), 0))((acc, num) => {
                if (num <= acc._1) (acc._1 % num, acc._2 + acc._1 / num)
                else acc
            })._2
        print(result)
    }
}