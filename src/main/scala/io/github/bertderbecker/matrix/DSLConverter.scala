package io.github.bertderbecker.matrix

import scala.language.implicitConversions


object DSLConverter {
  implicit def productss2seqs[I](products: Product*): Seq[Seq[I]] = products.map(_.productIterator.toSeq.map(_.asInstanceOf[I]))
}
