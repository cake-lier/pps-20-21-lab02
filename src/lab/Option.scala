package lab

sealed trait Option[A]
object Option {
    case class None[A]() extends Option[A]
    case class Some[A](a: A) extends Option[A]

    def filter[A, B >: A](option: Option[A])(predicate: B => Boolean): Option[A] = option match {
        case Some(a) => if (predicate(a)) {
            Some(a)
        } else {
            None()
        }
        case _ => None()
    }

    def map[A, B](option: Option[A])(function: A => B): Option[B] = option match {
        case Some(a) => Some(function(a))
        case _ => None()
    }

    def map2[A, B, C](option1: Option[A])(option2: Option[B])(bifunction: (A, B) => C): Option[C] = option1 match {
        case Some(a) => option2 match {
            case Some(b) => Some(bifunction(a, b))
            case _ => None()
        }
        case _ => None()
    }
}
