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

    val negVal: (String => Boolean) => String => Boolean = f => i => !f(i)

    def negDef[A](f: A => Boolean): A => Boolean = i => !f(i)

    val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y <= z

    val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y <= z

    def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y <= z

    def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y <= z

    def compose[I, T, O](f: T => O, g: I => T): I => O = i => f(g(i))
}
