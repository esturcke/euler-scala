package euler

import scala.collection.JavaConversions._
import scala.reflect.runtime.universe
import org.jsoup.Jsoup
import euler.util.Template

/**
 */
trait Problem {

  /** Returns the problem number */
  def id: Int

  /** Returns the problem title */
  def title: String

  /** Returns the solution to the problem */
  def solve: Long

  /** Prints the solution to STDOUT */
  def answer = println(solve)

  /** Prints the solution in a more descriptive form */ 
  def describe = println(s"The answer to problem ${id} (${title}) is ${solve}")

  /** Returns a String of the URI to the problem page */
  def uri = Problem.uri(id)

  /** Opens a browser window to the problem page */
  def goto = java.awt.Desktop.getDesktop().browse(java.net.URI.create(uri))

}

object Problem {

  /** Returns the solution to a problem */
  def solve(n: Int): Long = Problem(n).solve

  def apply(n: Int) = {
    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val module = runtimeMirror.staticModule(s"euler.Problem${n}")
    runtimeMirror.reflectModule(module).instance.asInstanceOf[Problem]
  }

  def uri(n: Int) = s"https://projecteuler.net/problem=${n}"

  def solved = (
    new java.io.File("src/main/scala/euler/").listFiles.map {
      f => """(?<=Problem)\d+(?=\.scala)""".r.findFirstIn(f.getName)
    }
    filter { _.isDefined }
    map    {
      case Some(a) => a.toInt
      case None    => 0
    }
  ).sorted.distinct

  def setup(n: Int) = {
    val doc  = Jsoup.connect(uri(n)).get
    val vars = Map(
      "title"       -> doc.select("#content h2").first.text,
      "n"           -> doc.select("#content h3").first.text.substring(8).toInt.toString,
      "description" -> (doc.select("#content .problem_content").iterator map { _.text } reduce { _ + "\n\n" + _ })
    )
    Template.process("src/main/resources/Problem.scala", s"src/main/scala/euler/Problem$n.scala", vars)
  }

}
