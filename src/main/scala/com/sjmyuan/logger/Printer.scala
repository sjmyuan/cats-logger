package com.sjmyuan.logger

import io.circe.Json
import cats.effect.kernel.Sync

trait Printer[M[_], A] {
  def print(content: A): M[Unit]
}

class DefaultJsonPrinter[M[_]: Sync] extends Printer[M, Json] {

  def print(content: Json): M[Unit] =
    Sync[M].delay(println(content.noSpaces))

}
