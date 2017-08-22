package io.github.bertderbecker.matrix

import scala.language.higherKinds

trait MatrixObjectOps[M[I] <: MatrixInstanceOps[I, M[I]]] {

  protected def newInstance[I](seq: Seq[Seq[I]]): M[I]

  def apply[I](seq: Seq[Seq[I]]): M[I] = newInstance(seq)

  def fill[I](columns: Int, rows: Int)(element: I): M[I] = apply(Seq.fill(rows)(Seq.fill(columns)(element)))

}
