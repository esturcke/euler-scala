package euler

import euler.math.Misc.sq

/**
 * '''Sum square difference'''
 *
 * [[http://projecteuler.net/problem=6 Project Euler Problem 6]]
 *
 * The sum of the squares of the first ten natural numbers is, 1² + 2² + ... + 10² = 385 The square of the sum of the first ten natural
 * numbers is, (1 + 2 + ... + 10)² = 552 = 3025 Hence the difference between the sum of the squares of the first ten natural numbers and the
 * square of the sum is 3025 − 385 = 2640. Find the difference between the sum of the squares of the first one hundred natural numbers and the
 * square of the sum.
 *
 * '''Solution'''
 *
 * Brute force calculation.
 */

object Problem6 extends Problem {

  def id    = 6
  def title = "Sum square difference"

  def sumSquare(n: Int): Long = (1L to n) reduce { _ + sq(_) }
  def squareSum(n: Int): Long = sq((1L to n) reduce { _ + _  })
  def sumSquareDiff(n: Int): Long = squareSum(n) - sumSquare(n)

  /** Returns the difference between the square of the sum 1..100 and the sum of the squares of 1..100 */
  def solve = sumSquareDiff(100)

}
