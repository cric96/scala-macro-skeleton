package org.cric.`macro`

import scala.reflect.macros.whitebox

/**
  * contains all macro definitions
  */
object Macros {
  def typeToString[T]: String =
    macro MacrosImpl.typeToString[T] //macro interface, define the contract
}

/**
  * contains macros implementations
  */
object MacrosImpl {
  def typeToString[T: c.WeakTypeTag](c: whitebox.Context): c.Expr[String] = {
    import c.universe._ //for quasitqoute
    c.Expr[String](q"${implicitly[c.WeakTypeTag[T]].toString}")
  }

}
