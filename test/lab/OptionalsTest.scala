package lab

import lab.Option.{None, Some, filter, map, map2}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OptionalsTest {
    val optionalInt: Option[Int] = Some(5)
    val optionalBoolean: Option[Boolean] = Some(true)
    val empty: Option[Int] = None()
    val positivePredicate: Int => Boolean = _ > 2
    val negativePredicate: Int => Boolean = _ > 8
    val bipredicate: (Int, Int) => Boolean = (x, y) => positivePredicate(x) && positivePredicate(y)

    @Test
    def testFilter(): Unit = {
        assertEquals(optionalInt, filter(optionalInt)(positivePredicate))
        assertEquals(empty, filter(optionalInt)(negativePredicate))
        assertEquals(empty, filter(empty)(positivePredicate))
    }

    @Test
    def testMap(): Unit = {
        assertEquals(optionalBoolean, map(optionalInt)(positivePredicate))
        assertEquals(empty, map(empty)(positivePredicate))
    }

    @Test
    def testMap2(): Unit = {
        assertEquals(empty, map2(empty)(empty)(bipredicate))
        assertEquals(empty, map2(empty)(optionalInt)(bipredicate))
        assertEquals(empty, map2(optionalInt)(empty)(bipredicate))
        assertEquals(optionalBoolean, map2(optionalInt)(optionalInt)(bipredicate))
    }
}
