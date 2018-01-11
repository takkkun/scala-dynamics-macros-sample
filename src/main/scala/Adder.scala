import scala.language.dynamics
import scala.language.experimental.macros

object Adder extends Dynamic {
  def applyDynamic(name: String)(value: Int): Int = macro AdderMacro.applyDynamic
}
