package io.github.sjmyuan.jlogger

import cats.effect.{Sync}
import cats.implicits._
import io.circe.Json
import JsonInstances._

class SimpleJsonLogger[M[_]: Sync] extends JLogger[M, Json] {

  override final def log(logLevel: LogLevel, attrs: Json): M[Unit] = for {
    _ <- Sync[M].delay(println(attrs.noSpaces))
  } yield ()

}
