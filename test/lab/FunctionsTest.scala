package lab

import lab.Functions._
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

    def testCurrying(predicate: Int => Int => Int => Boolean): Unit = {
        assertTrue(predicate(1)(2)(3))
        assertFalse(predicate(2)(1)(3))
        assertFalse(predicate(1)(3)(2))
        assertFalse(predicate(3)(2)(1))
    }

    @Test
    def testCurryingVal(): Unit = {
        testCurrying(p1)
    }

    @Test
    def testCurryingDef(): Unit = {
        testCurrying(p3)
    }

    def testNotCurrying(predicate: (Int, Int, Int) => Boolean): Unit = {
        assertTrue(predicate(1, 2, 3))
        assertFalse(predicate(2, 1, 3))
        assertFalse(predicate(1, 3, 2))
        assertFalse(predicate(3, 2, 1))
    }

    @Test
    def testNotCurryingVal(): Unit = {
        testNotCurrying(p2)
    }

    @Test
    def testNotCurryingDef(): Unit = {
        testNotCurrying(p4)
    }

    @Test
    def testComposition(): Unit = {
        assertEquals(9, compose[Int, Int, Int](_ - 1, _ * 2)(5))
        assertEquals("0.5 bar", compose[Int, Double, String](_ + " bar", _ / 2.0)(1))
    }
}
