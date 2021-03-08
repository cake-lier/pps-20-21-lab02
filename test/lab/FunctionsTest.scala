package lab

import lab.Functions.{negDef, negVal, parityDef, parityVal}
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class FunctionsTest {
    @Test
    def testParityVal(): Unit = {
        assertEquals("even", parityVal(14))
        assertEquals("odd", parityVal(9))
    }

    @Test
    def testParityDef(): Unit = {
        assertEquals("even", parityDef(14))
        assertEquals("odd", parityDef(9))
    }

    @Test
    def testNegVal(): Unit = {
        val empty: String => Boolean = _ == ""
        val notEmpty = negVal(empty)
        assertTrue(notEmpty("foo"))
        assertFalse(notEmpty(""))
    }

    @Test
    def testNegDef(): Unit = {
        val empty: String => Boolean = _ == ""
        val notEmpty = negDef(empty)
        assertTrue(notEmpty("foo"))
        assertFalse(notEmpty(""))
    }

    @Test
    def testNegDefInt(): Unit = {
        val even: Int => Boolean = _ % 2 == 0
        val odd = negDef(even)
        assertTrue(odd(9))
        assertFalse(odd(14))
    }
}