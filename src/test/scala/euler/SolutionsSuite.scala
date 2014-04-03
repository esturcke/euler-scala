package euler

import euler.Problem.solved
import org.scalatest._

class SolutionsSuite extends FunSuite with Matchers {

  for (n <- solved) test(s"Problem $n") {
    Problem(n).solve should be (Solution(n))
  }

}
