package euler

import euler.math.Prime.primes

/**
 * '''10001st prime'''
 *
 * [[http://projecteuler.net/problem=7 Project Euler Problem 7]]
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13. What is the 10 001st prime number?
 *
 * '''Solution'''
 *
 * Fetch 10001th prime from prime stream. 
 *
 */

object Problem7 extends Problem {

  def id    = 7
  def title = "10001st prime"

  /** Returns 10001th prime number */
  def solve = primes(10000)

}
