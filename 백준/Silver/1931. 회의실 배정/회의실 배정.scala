import java.io._

object Main {
    def main(args: Array[String]): Unit = {
        val br = new BufferedReader(new InputStreamReader(System.in));
        val n = br.readLine.toInt
        var arr = Vector[(Int, Int)]()
        for (i <- 1 to n) {
            val s = br.readLine.split(" ").map(_.toInt)
            arr = arr :+ (s(0), s(1))
        }
        
        print(arr.sortWith {case (t1, t2) => 
            if (t1._2 == t2._2) t1._1 < t2._1
            else t1._2 < t2._2}
            .foldLeft((0, (0, 0))){ case ((sum, t), cur) =>
                if (t._2 <= cur._1) sum + 1 -> cur
                else sum -> t
            }._1)
    }
}