package io.github.bertderbecker.matrix.generic.area

import scala.reflect.ClassTag

object Converter {

  def numberOf[T <: Area](implicit classTag: ClassTag[T]): Int =
    classTag.runtimeClass.getSimpleName
      .substring(
        classTag.runtimeClass.getSimpleName
          .indexOf(
            "s"
          ) + 1
      )
      .toInt

}
