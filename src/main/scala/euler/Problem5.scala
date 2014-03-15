package euler

import euler.math.Misc.lcm

/**
 * '''Smallest multiple'''
 *
 * [[http://projecteuler.net/problem=5 Project Euler Problem 5]]
 *
 * 2520 is the smallest number that can be divided by each of the
 * numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by
 * all of the numbers from 1 to 20?
 *
 * '''Solution'''
 *
 */

object Problem5 extends Problem {

  def id    = 5
  def title = "Smallest multiple"

  /** Returns the smallest number divisible by 1 to 20 */
  def solve = lcm(20L to 10 by -1)

}
