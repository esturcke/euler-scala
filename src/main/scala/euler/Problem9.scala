package euler

import euler.math.Misc.sq

/**
 * '''Special Pythagorean triplet'''
 *
 * [[http://projecteuler.net/problem=9 Project Euler Problem 9]]
 *
 * A Pythagorean triplet is a set of three natural numbers, a b c, for which, a² + b² = c² For example, 3² + 4² = 9 + 16 = 25 = 52. There
 * exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 *
 * '''Solution'''
 *
 * Brute force go through triplets until we find one that matches.
 */

object Problem9 extends Problem {

  def id    = 9
  def title = "Special Pythagorean triplet"
  
  private val triplets = for {
    a <- 1 to 1000
    b <- 1 to 1000
    c = 1000 - a - b
    if a <= b && b <= c
  } yield (a, b, c)

  /** Returns product of Prytagorean triplet for which the sum is 1000 */
  def solve = triplets find { t => sq(t._1) + sq(t._2) == sq(t._3) } match {
    case Some((a:Int, b:Int, c:Int)) => a * b * c
    case None                        => throw new Exception("No triplet found")
  }

}
