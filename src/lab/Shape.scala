package lab

sealed trait Shape
object Shape {
    case class Rectangle(base: Double, height: Double) extends Shape
}
