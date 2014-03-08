package euler

import org.scalatest._

class SolutionsSpec extends FlatSpec with Matchers {

  "The problems" should "have the correct solutions" in {
    Problem1.solve should be (  233168 )
    Problem2.solve should be ( 4613732 )
  }

}
