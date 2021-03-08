package lab

import lab.Option.{filter, map}
import lab.Option.Some
import lab.Option.None
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OptionalsTest {
    @Test
    def testFilter(): Unit = {
        val optional = Some(5)
        val odd: Int => Boolean = _ % 2 == 1
        assertEquals(optional, filter(optional, odd))
        val empty = None[Int]()
        assertEquals(empty, filter[Int, Int](optional, _ % 2 == 0))
        assertEquals(empty, filter(empty, odd))
    }

    @Test
    def testMap(): Unit = {
        val toString: Int => String = _ + ""
        assertEquals(Some("5"), map(Some(5), toString))
        assertEquals(None(), map(None(), toString))
    }
}
