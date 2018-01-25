
package me.jarleton.smacks.model

case class Adventurer(
                       name: String,
                       var x: Int,
                       var y: Int,
                       path: Array[Char],
                       var direction: Char,
                       var treasures: Int = 0
                     ) {
  def toRight = {

  }

  def toLeft = {

  }

  def move(land: Array[Array[(Int, Boolean)]]): Array[Array[(Int, Boolean)]] = {
    Array[Array[(Int,Boolean)]]()
  }
}