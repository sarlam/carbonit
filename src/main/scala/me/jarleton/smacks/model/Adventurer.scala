
package me.jarleton.smacks.model

object Directions {

  sealed trait EnumVal

  case object South extends EnumVal

  case object Est extends EnumVal

  case object North extends EnumVal

  case object West extends EnumVal

}

case class Adventurer(
                       name: String,
                       var x: Int,
                       var y: Int,
                       path: Array[Char],
                       var direction: Directions.EnumVal,
                       var treasures: Int = 0
                     ) {
  def toRight: Adventurer = {
    this.direction match {
      case Directions.North => this.direction = Directions.Est
      case Directions.Est => this.direction = Directions.South
      case Directions.South => this.direction = Directions.West
      case Directions.West => this.direction = Directions.North
    }
    this
  }

  def toLeft: Adventurer = {
    this.direction match {
      case Directions.North => this.direction = Directions.West
      case Directions.West => this.direction = Directions.South
      case Directions.South => this.direction = Directions.Est
      case Directions.Est => this.direction = Directions.North
    }
    this
  }

  def move(land: Array[Array[(Int, Boolean)]]): Array[Array[(Int, Boolean)]] = {
    Array[Array[(Int, Boolean)]]()
  }
}