package lab

import lab.Shape.Rectangle
import lab.ShapeUtils.{area, perimeter}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShapeTest {
    @Test
    def testRectangle(): Unit = {
        val rect = Rectangle(2, 3)
        assertEquals(10, perimeter(rect))
        assertEquals(6, area(rect))
    }
}
