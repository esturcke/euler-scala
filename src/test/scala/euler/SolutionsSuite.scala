package euler

import euler.Solution.solutions
import org.scalatest._

class SolutionsSuite extends FunSuite with Matchers {

  for ((n, solution) <- solutions) test(s"Problem $n") {
    Problem(n).solve should be (solution)
  }

}
