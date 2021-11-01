package com.sjmyuan.logger

import io.circe.Json
import cats.effect.kernel.Sync

trait Printer[M[_], A] {
  def print(content: A): M[Unit]
}

object Printer {
  def apply[M[_], A: Printer[M, _]] = implicitly[Printer[M, A]]
  implicit def generateJsonPrinter[M[_]: Sync]: Printer[M, Json] =
    new Printer[M, Json] {
      def print(content: Json): M[Unit] =
        Sync[M].delay(println(content.noSpaces))
    }
}
