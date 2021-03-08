package lab

import lab.Shape.{Circle, Rectangle}

object ShapeUtils {
    def perimeter(shape: Shape): Double = shape match {
        case Rectangle(base, height) => (base + height) * 2
        case Circle(radius) => 2 * Math.PI * radius
    }

    def area(shape: Shape): Double = shape match {
        case Rectangle(base, height) => base * height
        case Circle(radius) => Math.PI * Math.pow(radius, 2)
    }
}
