package io.github.sjmyuan.jlogger

import cats.effect.{Sync}
import io.circe.Json
import io.circe.syntax._
import java.time.Instant

class SimpleJsonLogger[M[_]: Sync]
    extends Logger[M, Json](new SimpleJsonPrinter[M]) {

  def generateContent(
      logLevel: LogLevel,
      now: Instant,
      attrs: Seq[Json]
  ): Json =
    attrs.foldLeft(
      Json.obj(
        "level" -> logLevel.toString.asJson,
        "time" -> now.asJson
      )
    )((acc, ele) => acc.deepMerge(ele))
}
