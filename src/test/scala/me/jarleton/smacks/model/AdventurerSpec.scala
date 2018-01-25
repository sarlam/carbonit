
package me.jarleton.smacks.model

import me.jarleton.smacks.excepetion.{IllegalMove, MoveOutOfBorder}
import org.scalatest.{FlatSpec, Matchers}

class AdventurerSpec extends FlatSpec with Matchers {
  final val NAME = "maria"

  "An Adventurer turning right" should "turn from South to West" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.South)
    a.toRight
    assert(a.direction == Directions.West)
  }

  it should "turn from West to North" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.West)
    a.toRight
    assert(a.direction == Directions.North)
  }

  it should "turn from North to Est" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.North)
    a.toRight
    assert(a.direction == Directions.Est)
  }

  it should "turn from Est to South" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.Est)
    a.toRight
    assert(a.direction == Directions.South)
  }

  "An Adventurer turning left" should "turn from South to Est" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.South)
    a.toLeft
    assert(a.direction == Directions.Est)
  }

  it should "turn from Est to North" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.Est)
    a.toLeft
    assert(a.direction == Directions.North)
  }

  it should "turn from North to West" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.North)
    a.toLeft
    assert(a.direction == Directions.West)
  }


  it should "turn from West to South" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.West)
    a.toLeft
    assert(a.direction == Directions.South)
  }

  "An Adventurer on the move" should "not go beyond upper border" in {
    val a = Adventurer(NAME, 0, 0, "".toCharArray, Directions.North)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(0)(0) = (0, true)

    assertThrows[MoveOutOfBorder] { // Result type: Assertion
      a.move(land)
    }
  }

  it should "not go beyond left border" in {
    val a = Adventurer(NAME, 0, 0, "".toCharArray, Directions.West)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(0)(0) = (0, true)

    assertThrows[MoveOutOfBorder] { // Result type: Assertion
      a.move(land)
    }
  }

  it should "not go beyond right border" in {
    val a = Adventurer(NAME, 2, 0, "".toCharArray, Directions.Est)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(2)(0) = (0, true)

    assertThrows[MoveOutOfBorder] { // Result type: Assertion
      a.move(land)
    }
  }

  it should "not go beyond lower border" in {
    val a = Adventurer(NAME, 0, 2, "".toCharArray, Directions.South)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(0)(2) = (0, true)

    assertThrows[MoveOutOfBorder] { // Result type: Assertion
      a.move(land)
    }
  }

  it should "move vertically to North" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.North)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(1)(1) = (0, true)

    a.move(land)
    assert(a.y == 0)
    assert(a.x == 1)
  }

  it should "move vertically to South" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.South)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(1)(1) = (0, true)

    a.move(land)
    assert(a.y == 2)
    assert(a.x == 1)
  }

  it should "move horizontally to West" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.Est)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(1)(1) = (0, true)

    a.move(land)
    assert(a.y == 1)
    assert(a.x == 0)
  }

  it should "move horizontally to Est" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.West)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, false))
    land(1)(1) = (0, true)

    a.move(land)
    assert(a.y == 1)
    assert(a.x == 2)
  }

  it should "not move toward a mountain" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.South)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (-1, false))
    land(1)(1) = (0, true)

    assertThrows[IllegalMove] { // Result type: Assertion
      a.move(land)
    }
  }

  it should "not move if another Adventurer is already there" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.South)
    val land = Array.tabulate[(Int, Boolean)](3, 3)((x, y) => (0, true))

    assertThrows[IllegalMove] { // Result type: Assertion
      a.move(land)
    }
  }
}
