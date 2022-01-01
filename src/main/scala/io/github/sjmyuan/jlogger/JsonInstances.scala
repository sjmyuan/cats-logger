package io.github.sjmyuan.jlogger

import cats.kernel.Monoid
import io.circe.Json

object JsonInstances {
  implicit val jsonMonoid: Monoid[Json] = new Monoid[Json] {

    override def empty: Json = Json.obj()
    override def combine(x: Json, y: Json): Json = x.deepMerge(y)

  }
}
