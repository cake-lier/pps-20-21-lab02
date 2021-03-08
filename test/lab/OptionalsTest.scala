package lab

import lab.Option.{filter, map}
import lab.Option.Some
import lab.Option.None
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OptionalsTest {
    val optional: Option[Int] = Some(5)
    val empty: Option[Int] = None()
    val greaterThanTwo: Int => Boolean = _ > 2

    @Test
    def testFilter(): Unit = {
        assertEquals(optional, filter(optional)(greaterThanTwo))
        assertEquals(empty, filter(optional)(_ > 8))
        assertEquals(empty, filter(empty)(greaterThanTwo))
    }

    @Test
    def testMap(): Unit = {
        assertEquals(Some(true), map(optional)(greaterThanTwo))
        assertEquals(empty, map(empty)(greaterThanTwo))
    }
}
