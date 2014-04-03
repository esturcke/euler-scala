package euler

import euler.math.Prime.primes

/**
 * '''Summation of primes'''
 *
 * [[http://projecteuler.net/problem=10 Project Euler Problem 10]]
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all the primes below two million.
 *
 * '''Solution'''
 *
 * Pull primes off of the prime stream below 2 million and then find the sum.
 */

object Problem10 extends Problem {

  def id    = 10
  def title = "Summation of primes"

  /** Returns the sum of primes below 2000000 */
  def solve = primes takeWhile { _ < 2000000 } reduce { _ + _ }

}
