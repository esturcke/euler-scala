package euler

import scala.io.Source
import scala.collection.immutable.Map
import scala.collection.immutable.TreeMap

/**
 */

object Solution {

  val solutions = readSolutions

  private def parse(line: String) = line.trim.split("\\s+") match {
    case Array(n, solution) => (n.toInt, solution.toLong)
  }

  private def readSolutions: Map[Int, Long] = {
    val source = Source.fromURL(getClass.getResource("/solutions"))
    source.getLines.foldLeft(new TreeMap[Int, Long]) {
      case (map, line) => map + parse(line)
    }
  }

  def apply(n: Int) = solutions(n)

}
