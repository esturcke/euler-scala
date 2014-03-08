package euler

/**
 * '''Multiples of 3 and 5'''
 *
 * [[http://projecteuler.net/problem=1 Project Euler Problem 1]]
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

object Problem1 extends Problem {

  def id    = 1
  def title = "Multiples of 3 and 5" 

  /** Returns the sum of muliples of `n` from `1` to `max` */
  private def sum(max: Long, n: Long) = {
    val count = (max - 1) / n
    n * count * (count + 1) / 2
  }

  /** Returns the sum of multiple multiples of `3` or `5` below `1000` */
  def solve = sum(1000, 3) + sum(1000, 5) - sum(1000, 15)

}
