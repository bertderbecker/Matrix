package io.github.bertderbecker.matrix

object MatrixUpdater {

  implicit class MatrixUpdaterSeqOps[I](seq: Seq[Seq[I]]) {

    def lastUpdated(newVal: Seq[I]): Seq[Seq[I]] = seq.updated(seq.indices.max, newVal)

    def toLastAppended(value: I): Seq[Seq[I]] = seq.lastUpdated(seq.last :+ value)
  }

}
