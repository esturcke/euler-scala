package euler

import scala.collection.SortedSet

/**
 * '''Largest palindrome product'''
 *
 * [[http://projecteuler.net/problem=4 Project Euler Problem 4]]
 *
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * '''Solution'''
 *
 * The products can be layed out in a 2-d matrix:
 *
 * {{{
 *         ... 998001
 *         ...
 *   4 6 8 ...   1998
 * 1 2 3 4 ...    999
 * }}}
 *
 * Then we can start searching from the top-right and make our way down. To do
 * this we add rows one by one to an ordered set, and start picking off that
 * queue until. The first palindrome is the solution.
 */

object Problem4 extends Problem {

  def id    = 4
  def title = "Largest palindrome product"

  private def isPalindrome(s: String)       = s == s.reverse
  private def isPalindrome(n: Int): Boolean = isPalindrome(n.toString)

  /*
   * This version is faster for small values, but blows the stack for larger values
   *
  def products(a: Int, b: Int): Stream[Int] = {
    def merge(a: Stream[Int], b: Stream[Int]): Stream[Int] = (a, b) match {
      case (Stream.Empty, _) => b
      case (_, Stream.Empty) => a
      case (x #:: xs, y #:: ys) => if (x > y) x #:: merge(xs, b) else y #:: merge(a, ys)
    }
    (b * b) #:: (if (a == b) Stream.empty else merge(Stream.range(b - 1, a - 1, -1) map { _ * b }, products(a, b - 1)))
  }
  */

  def products(min: Int, max: Int): Stream[Int] = {
    def find(min: Int, max: Int, q: SortedSet[Int]): Stream[Int] = {
      if      (min > max)                       q.toStream
      else if (q.isEmpty || max * max > q.head) (max * max) #:: find(min, max - 1, q ++ ((1 to max - 1) map { _ * max }))
      else                                      q.head      #:: find(min, max, q.tail)
    }
    find(min, max, SortedSet[Int]()(Ordering[Int].reverse))    
  }

  /** Returns the largest palindrom prouct from two 3-digit numbers */
  def solve = (products(100, 999) filter { isPalindrome }).head

}
