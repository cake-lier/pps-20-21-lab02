package lab

object Functions {
    val parityVal: Int => String = x => x % 2 match {
        case 0 => "even"
        case _ => "odd"
    }

    def parityDef(x: Int): String = x % 2 match {
        case 0 => "even"
        case 1 => "odd"
    }
}
