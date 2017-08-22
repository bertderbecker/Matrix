package io.github.bertderbecker.matrix

case class LocatedValue[I](position: Position, value: I)

object LocatedValue {
  def fromTuple[I](tuple: (Position, I)) = LocatedValue(tuple._1, tuple._2)
}
