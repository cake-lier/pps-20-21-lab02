package lab

import lab.Shape.Rectangle

object ShapeUtils {
    def perimeter(shape: Shape): Double = shape match {
        case Rectangle(base, height) => (base + height) * 2
    }

    def area(shape: Shape): Double = shape match {
        case Rectangle(base, height) => base * height
    }
}
