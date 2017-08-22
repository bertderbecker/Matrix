package io.github.bertderbecker.matrix

import org.apache.commons.lang3.StringUtils

trait MatrixInstanceOps[I, M <: MatrixInstanceOps[I, M]] {
  self: M =>

  val seq: Seq[Seq[I]]

  def copy(newSeq: Seq[Seq[I]]): M

  protected def updatedSeq(row: Int, column: Int, newVal: I): Seq[Seq[I]] =
    seq.updated(row, seq(row).updated(column, newVal))


  def updated(row: Int, column: Int)(newVal: I): M =
    copy(updatedSeq(row, column, newVal))

  def updated(pos: Position)(newVal: I): M =
    updated(pos.row, pos.column)(newVal)

  def updated(posSeq: Position*)(newVals: I*): M =
    (posSeq zip newVals).map(LocatedValue.fromTuple)
      .foldLeft(this)(
        (matrx: M, locVal: LocatedValue[I]) =>
          matrx.updated(locVal.position)(locVal.value)
      )

  def apply(row: Int, column: Int): I = seq(row)(column)

  def apply(pos: Position): I = apply(pos.row, pos.column)

  def contains(element: I): Boolean = seq.flatten.contains(element)

  def rows: Int = seq.size

  def columns: Int = seq(1).size

  def toSeq: Seq[Seq[I]] = seq

  override def toString: String = {
    val columnSeperator = "   "
    ("     " ++:
      (for (index <- seq.maxBy(_.size).indices)
        yield StringUtils.rightPad(index.toString, 25, ' ') + columnSeperator).mkString +: "\n" ++:
      (for (indexOfRow <- seq.indices)
        yield
          StringUtils.rightPad(indexOfRow.toString, 5, ' ') +
            seq(indexOfRow).map(element =>
              StringUtils.rightPad(element.toString, 25, ' ')
            ).mkString(columnSeperator) + "\n"
        )
      ).mkString
  }
}
