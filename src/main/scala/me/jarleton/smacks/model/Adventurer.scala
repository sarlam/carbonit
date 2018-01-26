
package me.jarleton.smacks.model

import me.jarleton.smacks.excepetion.{IllegalMove, MoveOutOfBorder}

/**
  * Directions Enumeration.
  */
object Directions {

  sealed trait EnumVal

  case object South extends EnumVal

  case object Est extends EnumVal

  case object North extends EnumVal

  case object West extends EnumVal

}

/**
  * Adventurer Model.
  *
  * @param name       adventurer name
  * @param y          current adventurer position y.
  * @param x          current adventurer position x.
  * @param path       full path walked by the adventurer.
  * @param direction  current direction.
  * @param treasures  number of already obtained treasures
  */
case class Adventurer(
                       name: String,
                       var y: Int,
                       var x: Int,
                       path: Array[Char],
                       var direction: Directions.EnumVal,
                       var treasures: Int = 0
                     ) {
  /**
    * change the direction of the adventurer to Right.
    *
    * @return Adventurer
    */
  def toRight: Adventurer = {
    this.direction match {
      case Directions.North => this.direction = Directions.Est
      case Directions.Est => this.direction = Directions.South
      case Directions.South => this.direction = Directions.West
      case Directions.West => this.direction = Directions.North
    }
    this
  }

  /**
    * change the direction of the adventurer to Left.
    *
    * @return Adventurer
    */
  def toLeft: Adventurer = {
    this.direction match {
      case Directions.North => this.direction = Directions.West
      case Directions.West => this.direction = Directions.South
      case Directions.South => this.direction = Directions.Est
      case Directions.Est => this.direction = Directions.North
    }
    this
  }

  /**
    * try to make the adventurer move to the next case in the land according to
    * his/her direction.
    *
    * @param land               the land the adventurer is currently crawling.
    * @throws MoveOutOfBorder   he/she try to leave the land.
    * @throws IllegalMove       he/she try to go through a mountain or another
    *                           adventurer.
    * @return a new updated land
    */
  //noinspection ScalaStyle
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