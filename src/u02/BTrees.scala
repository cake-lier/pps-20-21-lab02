package u02

object BTrees extends App {
    sealed trait Tree[A]
    object Tree {
        case class Leaf[A](value: A) extends Tree[A]
        case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

        def visit[A, B](tree: Tree[A])(branchReduce: B => B => B)(leafFunction: A => B): B = tree match {
            case Branch(l, r) => branchReduce(visit(l)(branchReduce)(leafFunction))(visit(r)(branchReduce)(leafFunction))
            case Leaf(e) => leafFunction(e)
        }

        def size[A](t: Tree[A]): Int = visit[A, Int](t)(l => r  => l + r)(_ => 1)

        def find[A](t: Tree[A], elem: A): Boolean = visit[A, Boolean](t)(l => r => l || r)(e => e == elem)

        def count[A](t: Tree[A], elem: A): Int = visit[A, Int](t)(l => r => l + r)(e => if (e == elem) { 1 } else { 0 })
    }

    import Tree._
    val tree = Branch(Branch(Leaf(1),Leaf(2)),Leaf(1))
    println(tree, size(tree)) // ..,3
    println( find(tree, 1)) // true
    println( find(tree, 4)) // false
    println( count(tree, 1)) // 2
}
