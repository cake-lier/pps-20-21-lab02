package lab

import lab.Option.{None, Some, filter, map, map2}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OptionalsTest {
    val optionalInt: Option[Int] = Some(5)
    val optionalBoolean: Option[Boolean] = Some(true)
    val empty: Option[Int] = None()
    val greaterThanTwo: Int => Boolean = _ > 2

    @Test
    def testFilter(): Unit = {
        assertEquals(optionalInt, filter(optionalInt)(greaterThanTwo))
        assertEquals(empty, filter(optionalInt)(_ > 8))
        assertEquals(empty, filter(empty)(greaterThanTwo))
    }

    @Test
    def testMap(): Unit = {
        assertEquals(optionalBoolean, map(optionalInt)(greaterThanTwo))
        assertEquals(empty, map(empty)(greaterThanTwo))
    }

    @Test
    def testMap2(): Unit = {
        val bothGreaterThanTwo: (Int, Int) => Boolean = (x, y) => greaterThanTwo(x) && greaterThanTwo(y)
        assertEquals(empty, map2(empty)(empty)(bothGreaterThanTwo))
        assertEquals(empty, map2(empty)(optionalInt)(bothGreaterThanTwo))
        assertEquals(empty, map2(optionalInt)(empty)(bothGreaterThanTwo))
        assertEquals(optionalBoolean, map2(optionalInt)(optionalInt)(bothGreaterThanTwo))
    }
}
