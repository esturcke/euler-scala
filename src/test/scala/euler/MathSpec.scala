package euler.math

import org.scalatest._

class MathSpec extends FlatSpec with Matchers {

  "The prime stream" should "contain the correct fist 10 primes" in {
    (Prime.primes take 10).toList should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
  }

  it should "be able to get the correct 500th prime" in {
    (Prime.primes drop 499).head should be (3571)
  }

  "The gcd" should "be correct for 140 and 2400" in {
    Misc.gcd(2400, 140) should be (20)
    Misc.gcd(140, 2400) should be (20)
  }

  it should "be correct for 7 and 11" in {
    Misc.gcd(7, 11) should be (1)
    Misc.gcd(11, 7) should be (1)
  }

  "The lcm" should "be correct for 14 and 21" in {
    Misc.lcm(14, 21) should be (42)
    Misc.lcm(21, 14) should be (42)
  }

  it should "be correct for 1, 2, ... 10" in {
    Misc.lcm(1L to 10) should be (2520)
  }

}
