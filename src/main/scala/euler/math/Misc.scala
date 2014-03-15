package euler.math

/**
 * Streams of primes
 */

object Misc {

  def gcd(a: Long, b: Long): Long = if (a == 0) b else gcd(b % a, a)

  def lcm(a: Long, b: Long): Long = a * b / gcd(a, b)

  def lcm(ns: Seq[Long]): Long = ns reduce lcm

}
