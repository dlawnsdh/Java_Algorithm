import java.io._

object Main {
    def main(args: Array[String]): Unit = {
        val br = new BufferedReader(new InputStreamReader(System.in));
        val n = br.readLine.toInt
        val a = br.readLine.split(" ").map(_.toInt)
        val b = br.readLine.split(" ").map(_.toInt)
        print(a.sorted.zip(b.sorted.reverse).map(t => t._1 * t._2).sum)
    }
}