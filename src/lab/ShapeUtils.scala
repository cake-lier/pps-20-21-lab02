package lab

import lab.Shape.{Circle, Rectangle, Square}

object ShapeUtils {
    def perimeter(shape: Shape): Double = shape match {
        case Rectangle(base, height) => (base + height) * 2
        case Circle(radius) => 2 * Math.PI * radius
        case Square(side) => side * 4
    }

    def area(shape: Shape): Double = shape match {
        case Rectangle(base, height) => base * height
        case Circle(radius) => Math.PI * Math.pow(radius, 2)
        case Square(side) => Math.pow(side, 2)
    }
}
