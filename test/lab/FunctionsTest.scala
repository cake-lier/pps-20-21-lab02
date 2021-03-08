package lab

import lab.Functions.{negDef, negVal, parityDef, parityVal}
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class FunctionsTest {
    def testParity(parity: Int => String): Unit = {
        assertEquals("even", parity(14))
        assertEquals("odd", parity(9))
    }

    @Test
    def testParityVal(): Unit = {
        testParity(parityVal)
    }

    @Test
    def testParityDef(): Unit = {
        testParity(parityDef)
    }

    def testNeg[A](predicate: A => Boolean, neg: (A => Boolean) => A => Boolean, positiveMatch: A, negativeMatch: A): Unit = {
        val negated = neg(predicate)
        assertTrue(negated(positiveMatch))
        assertFalse(negated(negativeMatch))
    }

    def testNegString(neg: (String => Boolean) => String => Boolean): Unit = {
        testNeg[String](_ == "", neg, "foo", "")
    }

    @Test
    def testNegValString(): Unit = {
        testNegString(negVal)
    }

    @Test
    def testNegDefString(): Unit = {
        testNegString(negDef)
    }

    @Test
    def testNegDefInt(): Unit = {
        testNeg[Int](_ % 2 == 0, negDef, 9, 14)
    }
}