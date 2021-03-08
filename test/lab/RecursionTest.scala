package lab

import lab.Recursion.fib
import org.junit.jupiter.api.Assertions.{assertEquals, assertThrows}
import org.junit.jupiter.api.Test

class RecursionTest {
    val firstFiveFibonacci: (Int, Int, Int, Int, Int) = (0, 1, 1, 2, 3)
    val negativeNumber: Int = -7

    @Test
    def testFibonacci(): Unit = {
        assertEquals(firstFiveFibonacci, (fib(0), fib(1), fib(2), fib(3), fib(4)))
        assertThrows(classOf[IllegalArgumentException], () => fib(negativeNumber))
    }
}
