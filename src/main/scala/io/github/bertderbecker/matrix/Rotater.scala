package io.github.bertderbecker.matrix

import scala.collection.mutable.ArrayBuffer

object Rotater {

  implicit class RotaterSeqOps[I](seq: Seq[Seq[I]]) {

    private def rotatedBy45degrees: Seq[Seq[I]] = {
      val rotated =
        ArrayBuffer.fill(seq.size + seq.head.size - 1)(ArrayBuffer.empty[I])
      for (j <- seq.head.indices; i <- seq.indices)
        rotated(i + j).+=(seq(i)(j))
      rotated
    }

    private def rotatedBy90degrees: Seq[Seq[I]] =
      seq.head.indices.map(i => seq.map(_ (i)))

    def rotatedBy(degrees: Degrees): Seq[Seq[I]] = {
      degrees match {
        case Degrees._0 => seq
        case Degrees._45 => rotatedBy45degrees
        case Degrees._90 => rotatedBy90degrees
        case Degrees._135 => new RotaterSeqOps(seq.map(_.reverse)).rotatedBy45degrees
        case _ => throw new IllegalArgumentException("Impossible degrees.")
      }
    }
  }

}
