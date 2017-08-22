package io.github.bertderbecker.matrix


case class Position(row: Int, column: Int) {
  override def toString: String = "P(" + row + "," + column + ")"
}
