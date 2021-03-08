package lab

import lab.Functions.{parityDef, parityVal}
import org.junit.jupiter.api.Assertions.assertEquals
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
}