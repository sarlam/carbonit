package me.jarleton.smacks

/**
  * Just say hello !
  */
object Hello extends Greeting with App {
  println(greeting)
}

/**
  *
  */
trait Greeting {
  /**
    * english hello !
    */
  lazy val greeting: String = "hello"
}
