package lab

import scala.annotation.tailrec

object Recursion {
    def fib(n: Int): Int = {
        @tailrec
        def _fib(n: Int, secondToLast: Int, last: Int): Int = n match {
            case 0 => secondToLast
            case 1 => last
            case _ => _fib(n - 1, last, last + secondToLast)
        }
        _fib(n, 0, 1)
    }
}
