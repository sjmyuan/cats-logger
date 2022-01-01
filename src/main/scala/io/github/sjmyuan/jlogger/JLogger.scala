package io.github.sjmyuan.jlogger

import cats.implicits._
import java.time.Instant
import cats.effect.{Clock}
import cats.kernel.Monoid
import cats.Monad
abstract class JLogger[M[_]: Monad, B: Monoid](implicit
    clock: Clock[M],
    stringFormatter: Formatter[String, B],
    instantFormatter: Formatter[Instant, B]
) {
  final def info[A: Formatter[*, B]](
      description: String,
      data: (String, A)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.INFO.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A, B].format(data._1, data._2)
      ).combineAll
      _ <- log(LogLevel.INFO, content)
    } yield ()

  final def info[A1: Formatter[*, B], A2: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.INFO.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2)
      ).combineAll
      _ <- log(LogLevel.INFO, content)
    } yield ()

  final def info[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.INFO.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2)
      ).combineAll
      _ <- log(LogLevel.INFO, content)
    } yield ()

  final def info[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ], A4: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.INFO.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2),
        Formatter[A4, B].format(data4._1, data4._2)
      ).combineAll
      _ <- log(LogLevel.INFO, content)
    } yield ()

  final def info[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ], A4: Formatter[*, B], A5: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4),
      data5: (String, A5)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.INFO.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2),
        Formatter[A4, B].format(data4._1, data4._2),
        Formatter[A5, B].format(data5._1, data5._2)
      ).combineAll
      _ <- log(LogLevel.INFO, content)
    } yield ()

  final def warn[A: Formatter[*, B]](
      description: String,
      data: (String, A)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.WARNING.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A, B].format(data._1, data._2)
      ).combineAll
      _ <- log(LogLevel.WARNING, content)
    } yield ()

  final def warn[A1: Formatter[*, B], A2: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.WARNING.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2)
      ).combineAll
      _ <- log(LogLevel.WARNING, content)
    } yield ()

  final def warn[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.WARNING.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2)
      ).combineAll
      _ <- log(LogLevel.WARNING, content)
    } yield ()

  final def warn[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ], A4: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.WARNING.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2),
        Formatter[A4, B].format(data4._1, data4._2)
      ).combineAll
      _ <- log(LogLevel.WARNING, content)
    } yield ()

  final def warn[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ], A4: Formatter[*, B], A5: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4),
      data5: (String, A5)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.WARNING.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2),
        Formatter[A4, B].format(data4._1, data4._2),
        Formatter[A5, B].format(data5._1, data5._2)
      ).combineAll
      _ <- log(LogLevel.WARNING, content)
    } yield ()

  final def error[A: Formatter[*, B]](
      description: String,
      data: (String, A)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.ERROR.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A, B].format(data._1, data._2)
      ).combineAll
      _ <- log(LogLevel.ERROR, content)
    } yield ()

  final def error[A1: Formatter[*, B], A2: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.ERROR.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2)
      ).combineAll
      _ <- log(LogLevel.ERROR, content)
    } yield ()

  final def error[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.ERROR.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2)
      ).combineAll
      _ <- log(LogLevel.ERROR, content)
    } yield ()

  final def error[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ], A4: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.ERROR.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2),
        Formatter[A4, B].format(data4._1, data4._2)
      ).combineAll
      _ <- log(LogLevel.ERROR, content)
    } yield ()

  final def error[A1: Formatter[*, B], A2: Formatter[*, B], A3: Formatter[
    *,
    B
  ], A4: Formatter[*, B], A5: Formatter[*, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4),
      data5: (String, A5)
  ): M[Unit] =
    for {
      now <- clock.realTime
      content = List(
        Formatter[String, B].format("level", LogLevel.ERROR.toString),
        Formatter[Instant, B]
          .format("time", Instant.ofEpochMilli(now.toMillis)),
        Formatter[String, B].format("description", description),
        Formatter[A1, B].format(data1._1, data1._2),
        Formatter[A2, B].format(data2._1, data2._2),
        Formatter[A3, B].format(data3._1, data3._2),
        Formatter[A4, B].format(data4._1, data4._2),
        Formatter[A5, B].format(data5._1, data5._2)
      ).combineAll
      _ <- log(LogLevel.ERROR, content)
    } yield ()

  def log(logLevel: LogLevel, attrs: B): M[Unit]
}
