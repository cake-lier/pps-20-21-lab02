package lab

import lab.Recursion.fib
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RecursionTest {
    @Test
    def testFibonacci(): Unit = {
        assertEquals((0, 1, 1, 2, 3), (fib(0), fib(1), fib(2), fib(3), fib(4)))
    }
}
