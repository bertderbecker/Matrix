package io.github.bertderbecker.matrix

class Matrix[I](val seq: Seq[Seq[I]]) extends MatrixInstanceOps[I, Matrix[I]] {

  override def copy(newSeq: Seq[Seq[I]]): Matrix[I] = new Matrix(seq)
}

object Matrix extends MatrixObjectOps[Matrix] {

  override protected def newInstance[I](seq: Seq[Seq[I]]): Matrix[I] = new Matrix[I](seq)
}