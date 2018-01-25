
package me.jarleton.smacks.model

import me.jarleton.smacks.excepetion.MoveOutOfBorder

object Directions {

  sealed trait EnumVal

  case object South extends EnumVal

  case object Est extends EnumVal

  case object North extends EnumVal

  case object West extends EnumVal

}

case class Adventurer(
                       name: String,
                       var y: Int,
                       var x: Int,
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

  @throws[MoveOutOfBorder]("when adventurer want to leave the land")
  def move(land: Array[Array[(Int, Boolean)]]): Array[Array[(Int, Boolean)]] = {
    Array[Array[(Int, Boolean)]]()
  }
}