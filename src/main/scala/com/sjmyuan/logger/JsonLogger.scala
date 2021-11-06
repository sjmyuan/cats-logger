package com.sjmyuan.logger

import cats.effect.kernel.Sync
import cats.effect.kernel.Clock
import io.circe.Json
import io.circe.syntax._
import java.time.Instant
import io.circe.Encoder

class JsonLogger[M[_]: Sync](implicit clock: Clock[M])
    extends Logger[M, Json](new DefaultJsonPrinter[M]) {

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
