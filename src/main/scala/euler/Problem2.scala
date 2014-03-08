package euler

object Problem2 extends Problem {
  def id    = 2
  def title = "Even Fibonacci numbers"

  private lazy val fib: Stream[Long] = 0 #:: 1 #:: fib.zip(fib.tail).map { n => n._1 + n._2 } 
    
  def solve = fib takeWhile { _ < 4000000 } filter { _ % 2 == 0 } reduceLeft { _ + _ }
}
