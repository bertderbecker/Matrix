package io.github.bertderbecker.matrix

import enumeratum.values.{IntEnum, IntEnumEntry}

sealed abstract class Degrees(override val value: Int)
  extends IntEnumEntry {

  override def toString: String = value.toString + " degrees"

}

object Degrees extends IntEnum[Degrees] {
  //TODO: use shapeless ?

  implicit class DegreesIntOps(i: Int) {
    def degrees: Degrees = Degrees.withValue(i)
  }

  case object _0 extends Degrees(0)

  case object _45 extends Degrees(45)

  case object _90 extends Degrees(90)

  case object _135 extends Degrees(135)

  case object _180 extends Degrees(180)

  case object _225 extends Degrees(225)

  case object _270 extends Degrees(270)

  case object _315 extends Degrees(315)

  case object _360 extends Degrees(360)


  override def values = findValues

}