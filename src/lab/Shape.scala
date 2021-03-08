package lab

sealed trait Shape
object Shape {
    case class Rectangle(base: Double, height: Double) extends Shape
    case class Circle(radius: Double) extends Shape
    case class Square(side: Double) extends Shape
}
