package com.sjmyuan.logger

import cats.effect.kernel.Sync
import cats.effect.kernel.Clock
import io.circe.Json
import io.circe.syntax._
import java.time.Instant
import io.circe.Encoder

class Self4jJsonLogger[M[_]: Sync]
    extends Logger[M, Json](new Self4jJsonPrinter[M]) {

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
