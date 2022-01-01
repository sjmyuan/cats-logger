package io.github.sjmyuan.jlogger

import cats.effect.{Sync}
import cats.implicits._
import io.circe.Json
import JsonInstances._
import org.slf4j.Logger

class Self4jJsonLogger[M[_]: Sync](logger: Logger) extends JLogger[M, Json] {

  override final def log(logLevel: LogLevel, attrs: Json): M[Unit] = for {

    _ <-
      Sync[M].delay({
        logLevel match {
          case LogLevel.WARNING => logger.warn(attrs.noSpaces)
          case LogLevel.ERROR   => logger.error(attrs.noSpaces)
          case LogLevel.INFO    => logger.info(attrs.noSpaces)
        }
      })

  } yield ()

}
