package euler

import org.scalatest._

class SolutionsSuite extends FunSuite with Matchers {

  /*
  "The problems" should "have the correct solutions" in {
    Problem1.solve should be (  233168 )
    Problem2.solve should be ( 4613732 )
    Problem3.solve should be (    6857 )
    Problem4.solve should be (  906609 )
  }
*/
  test("Problem 1") { Problem1.solve should be (  233168 ) }
  test("Problem 2") { Problem2.solve should be ( 4613732 ) }
  test("Problem 3") { Problem3.solve should be (    6857 ) }
  test("Problem 4") { Problem4.solve should be (  906609 ) }
}
