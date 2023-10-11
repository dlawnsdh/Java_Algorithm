import scala.io.StdIn.readLine

object Main {
    def main(args: Array[String]): Unit = {
        val n = readLine.toInt
        (1 to n).foldLeft(List[BigInt]())((acc, _) => {
            val str = readLine.split("[a-z]")
                .filter(_.nonEmpty)
                .map(num => BigInt(num))
                .toList
            acc.concat(str)
        }).sorted.foreach(println)
    }
}