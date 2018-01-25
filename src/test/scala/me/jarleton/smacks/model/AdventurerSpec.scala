
package me.jarleton.smacks.model

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
    a.toRight
    assert(a.direction == Directions.West)
  }


  it should "turn from West to South" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, Directions.West)
    a.toRight
    assert(a.direction == Directions.South)
  }
}
