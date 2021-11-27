package io.github.sjmyuan.jlogger

import io.circe.Encoder
import io.circe.Json
import io.circe.syntax._

trait Formatter[A, B] {
  def format(key: String, value: A): B
}

object Formatter {
  def apply[A, B](implicit formatter: Formatter[A, B]): Formatter[A, B] =
    formatter

  implicit def generateJsonFormatter[A: Encoder]: Formatter[A, Json] =
    new Formatter[A, Json] {
      def format(key: String, value: A): Json = Json.obj(key -> value.asJson)
    }
}
