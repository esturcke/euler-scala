package euler.math

import org.scalatest._

class MathSpec extends FlatSpec with Matchers {

  "The prime stream" should "contain the correct fist 10 primes" in {
    (Prime.primes take 10).toList should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
  }

  it should "be able to get the correct 500th prime" in {
    (Prime.primes drop 499).head should be (3571)
  }

}
