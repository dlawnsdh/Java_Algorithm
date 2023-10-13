import java.io._

object Main {
    def main(args: Array[String]): Unit = {
        val br = new BufferedReader(new InputStreamReader(System.in));
        val n = br.readLine.toInt
        var arr = Vector[Int]()
        for (i <- 1 to n) 
            arr = arr :+ br.readLine.toInt
        
        print(arr.sorted.zipWithIndex.map { case (o, i) => o * (arr.size - i)}.max)
    }
}