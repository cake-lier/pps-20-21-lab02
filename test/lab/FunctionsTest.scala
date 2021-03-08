package lab

import lab.Functions._
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class FunctionsTest {
    val evenNumber: Int = 14
    val oddNumber: Int = 9
    val nonEmptyString = "foo"
    val emptyString = ""
    val isEmpty: String => Boolean = _ == emptyString
    val isEven: Int => Boolean = _ % 2 == 0
    val lowestElement = 1
    val middleElement = 2
    val highestElement = 3
    val f1: Int => Int = _ - 1
    val g1: Int => Int = _ * 2
    val x1 = 5
    val f2: Double => String = _ + " bar"
    val g2: Int => Double = _ / 2.0
    val x2 = 1

    def testParity(parity: Int => String): Unit = {
        assertEquals("even", parity(evenNumber))
        assertEquals("odd", parity(oddNumber))
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
        testNeg(isEmpty, neg, nonEmptyString, emptyString)
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
        testNeg[Int](isEven, negDef, oddNumber, evenNumber)
    }

    def testCurrying(predicate: Int => Int => Int => Boolean): Unit = {
        assertTrue(predicate(lowestElement)(middleElement)(highestElement))
        assertFalse(predicate(middleElement)(lowestElement)(highestElement))
        assertFalse(predicate(lowestElement)(highestElement)(middleElement))
        assertFalse(predicate(highestElement)(middleElement)(lowestElement))
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
        assertTrue(predicate(lowestElement, middleElement, highestElement))
        assertFalse(predicate(middleElement, lowestElement, highestElement))
        assertFalse(predicate(lowestElement, highestElement, middleElement))
        assertFalse(predicate(highestElement, middleElement, lowestElement))
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
        assertEquals(f1(g1(x1)), compose(f1, g1)(x1))
        assertEquals(f2(g2(x2)), compose(f2, g2)(x2))
    }
}
