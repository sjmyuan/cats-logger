package com.sjmyuan.logger

import cats.effect.kernel.Sync
import io.circe.Json
import io.circe.syntax._
import java.time.Instant
import io.circe.Encoder

class JsonLogger[M[_]: Sync] extends Logger[M, Json] {
  def info(details: Json*): M[Json] =
    Sync[M].pure(
      details.foldLeft(Json.obj("level" -> "INFO".asJson))((acc, ele) =>
        acc.deepMerge(ele)
      )
    )
  def warn(details: Json*): M[Json] =
    Sync[M].pure(
      details.foldLeft(Json.obj("level" -> "WARN".asJson))((acc, ele) =>
        acc.deepMerge(ele)
      )
    )
  def error(details: Json*): M[Json] =
    Sync[M].pure(
      details.foldLeft(Json.obj("level" -> "ERROR".asJson))((acc, ele) =>
        acc.deepMerge(ele)
      )
    )
  def output(value: Json): M[Unit] = {
    Sync[M].delay(
      println(
        value.deepMerge(Json.obj("timestamp" -> Instant.now.asJson)).spaces2
      )
    )
  }
}

object JsonLogger {
  implicit def generateJsonFormatter[A: Encoder]: Formatter[A, Json] =
    new Formatter[A, Json] {
      def format(key: String, value: A): Json = Json.obj(key -> value.asJson)
    }
}
