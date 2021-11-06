package com.sjmyuan.logger

import io.circe.Json
import cats.effect.kernel.Sync
import org.slf4j.LoggerFactory

trait Printer[M[_], A] {
  def print(logLevel: LogLevel, content: A): M[Unit]
}

class SimpleJsonPrinter[M[_]: Sync] extends Printer[M, Json] {

  def print(logLevel: LogLevel, content: Json): M[Unit] =
    Sync[M].delay(println(content.noSpaces))

}

class Self4jJsonPrinter[M[_]: Sync] extends Printer[M, Json] {

  private val logger = LoggerFactory.getLogger(getClass())

  def print(logLevel: LogLevel, content: Json): M[Unit] = {

    val body = content.noSpaces

    Sync[M].delay({
      logLevel match {
        case LogLevel.WARNING => logger.warn(body)
        case LogLevel.ERROR   => logger.error(body)
        case LogLevel.INFO    => logger.info(body)
      }
    })
  }
}
