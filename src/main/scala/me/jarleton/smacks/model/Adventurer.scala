
package me.jarleton.smacks.model

import me.jarleton.smacks.excepetion.{IllegalMove, MoveOutOfBorder}

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
  @throws[IllegalMove]("whan adventurer want to go through others or mountains")
  def move(land: Array[Array[(Int, Boolean)]]): Array[Array[(Int, Boolean)]] = {
    val x = this.x
    val y = this.y
    val pos = land(y)(x)
    this.direction match {
      case Directions.North =>
        if (y == 0) throw new MoveOutOfBorder
        val nextPos = land(y - 1)(x)
        if (nextPos._1 == -1 || nextPos._2) throw new IllegalMove

        this.y -= 1

      case Directions.West =>
        if (x == 0) throw new MoveOutOfBorder
        val nextPos = land(y)(x - 1)
        if (nextPos._1 == -1 || nextPos._2) throw new IllegalMove

        this.x -= 1

      case Directions.South =>
        if (y == land.length - 1) throw new MoveOutOfBorder
        val nextPos = land(y + 1)(x)
        if (nextPos._1 == -1 || nextPos._2) throw new IllegalMove

        this.y += 1

      case Directions.Est =>
        if (x == land(0).length - 1) throw new MoveOutOfBorder
        val nextPos = land(y)(x + 1)
        if (nextPos._1 == -1 || nextPos._2) throw new IllegalMove

        this.x += 1
    }
    land
  }
}