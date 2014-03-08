package euler

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
  def uri = s"https://projecteuler.net/problem=${id}"

  /** Opens a browser window to the problem page */
  def goto = java.awt.Desktop.getDesktop().browse(java.net.URI.create(uri))

}
