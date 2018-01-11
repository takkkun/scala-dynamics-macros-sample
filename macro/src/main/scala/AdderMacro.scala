import scala.reflect.macros.blackbox.Context

object AdderMacro {
  def applyDynamic(c: Context)(name: c.Expr[String])(value: c.Expr[Int]): c.Expr[Int] = {
    import c.universe._

    val Literal(Constant(numName: String)) = name.tree

    if (!increments.isDefinedAt(numName)) {
      c.error(c.enclosingPosition, s"$numName is not supported")
    }

    val increment = Literal(Constant(increments(numName)))

    c.Expr[Int](q"$value + $increment")
  }

  val increments: Map[String, Int] = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3
  )
}
