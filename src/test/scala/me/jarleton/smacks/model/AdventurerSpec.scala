
package me.jarleton.smacks.model

import org.scalatest.{FlatSpec, Matchers}


class AdventurerSpec extends FlatSpec with Matchers {
  final val NAME = "maria"

  "An Adventurer turning right" should "turn from South to West" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'S')
    a.toRight
    assert(a.direction == 'O')
  }

  it should "turn from West to North" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'O')
    a.toRight
    assert(a.direction == 'N')
  }

  it should "turn from North to Est" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'N')
    a.toRight
    assert(a.direction == 'E')
  }

  it should "turn from Est to South" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'E')
    a.toRight
    assert(a.direction == 'S')
  }

  "An Adventurer turning left" should "turn from South to Est" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'S')
    a.toLeft
    assert(a.direction == 'E')
  }

  it should "turn from Est to North" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'E')
    a.toLeft
    assert(a.direction == 'N')
  }

  it should "turn from North to West" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'N')
    a.toRight
    assert(a.direction == 'O')
  }


  it should "turn from West to South" in {
    val a = Adventurer(NAME, 1, 1, "".toCharArray, 'O')
    a.toRight
    assert(a.direction == 'S')
  }
}
