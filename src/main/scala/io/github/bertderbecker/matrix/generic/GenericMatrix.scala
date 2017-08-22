package io.github.bertderbecker.matrix.generic

import io.github.bertderbecker.matrix.Matrix
import io.github.bertderbecker.matrix.generic.area.Converter._
import io.github.bertderbecker.matrix.generic.area.{Columns, Rows}

import scala.reflect.ClassTag

//TODO: implement Bounds with Shapeless?
class GenericMatrix[R <: Rows : ClassTag, C <: Columns : ClassTag, I](seq: Seq[Seq[I]])
  extends Matrix[I](seq) {

  override def copy(newSeq: Seq[Seq[I]]): GenericMatrix[R, C, I] = new GenericMatrix[R, C, I](seq)

}

object GenericMatrix {

  protected def newInstance[R <: Rows : ClassTag, C <: Columns : ClassTag, I](seq: Seq[Seq[I]]): GenericMatrix[R, C, I] = new GenericMatrix[R, C, I](seq)

  def apply[R <: Rows : ClassTag, C <: Columns : ClassTag, I](seq: Seq[Seq[I]]): GenericMatrix[R, C, I] = {
    val sizes = seq.map(_.size)

    if (sizes.max != sizes.min)
      throw new IllegalArgumentException(
        "You cannot have different row sizes in a matrix!")
    if (numberOf[R] != seq.size || numberOf[C] != sizes.max)
      throw new IllegalArgumentException("This is not a correct size.")

    newInstance(seq)
  }

  def fill[R <: Rows : ClassTag, C <: Columns : ClassTag, I](rows: Int, columns: Int)(element: I): GenericMatrix[R, C, I] =
    apply(Seq.fill(rows)(Seq.fill(columns)(element)))
}
