package lab

import lab.Shape.{Circle, Rectangle}
import lab.ShapeUtils.{area, perimeter}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShapeTest {
    @Test
    def testRectangle(): Unit = {
        val rectangleBase = 2
        val rectangleHeight = 3
        val rectangle = Rectangle(rectangleBase, rectangleHeight)
        assertEquals(rectangleBase * 2 + rectangleHeight * 2, perimeter(rectangle))
        assertEquals(rectangleBase * rectangleHeight, area(rectangle))
    }

    @Test
    def testCircle(): Unit = {
        val circleRadius = 2
        val circle = Circle(circleRadius)
        assertEquals(2 * Math.PI * circleRadius, perimeter(circle))
        assertEquals(Math.PI * Math.pow(circleRadius, 2), area(circle))
    }
}
