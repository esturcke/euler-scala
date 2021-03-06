package euler.math

import euler.math.Misc.sq

/**
 * Streams of primes
 */

object Prime {
  
  private def from(n: Long, Δ: Long = 1) = Stream.iterate(n) { _ + Δ }

  lazy val primes: Stream[Long] = 2 #:: (
    from(3, 2) filter { n => primes takeWhile { sq(_) <= n } forall { n % _ > 0 } }
  )

  /** Returns a List of prime factors of `n` from largest to smallest including duplicates */
  def factor(n: Long): List[Long] = {
    def find(m: Long, primes: Stream[Long], factors: List[Long]): List[Long] = m match {
      case 1 => factors
      case _ => primes dropWhile { m % _ > 0 } match {
        case factor #:: _ => find(m / factor, primes, factor :: factors)
      }
    }
    find(n, primes, Nil)
  }

  def factorCount(n: Long) = {
    val sqrt = math.sqrt(n).toLong
    2 * ((1L to sqrt) filter { n % _ == 0 }).length - (if (n == sqrt * sqrt) 1 else 0)
  }

}
