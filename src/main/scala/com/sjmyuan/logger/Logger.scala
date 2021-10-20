package com.sjmyuan.logger

import cats.effect.kernel.Sync
import cats.implicits._

trait Formatter[A, B] {
  def format(key: String, value: A): B
}

object Formatter {
  def apply[A, B](implicit formatter: Formatter[A, B]): Formatter[A, B] =
    formatter
}

trait Logger[M[_]: Sync, B] {
  final def info[A: Formatter[_, B]](
      description: String,
      data: (String, A)
  ): M[Unit] = info(Formatter[A, B].format(data._1, data._2)).flatMap(output)

  final def info[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit] = info(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2)
  ).flatMap(output)

  final def info[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit] = info(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2)
  ).flatMap(output)

  final def info[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4)
  ): M[Unit] = info(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2),
    Formatter[A4, B].format(data4._1, data4._2)
  ).flatMap(output)

  final def info[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4),
      data5: (String, A5)
  ): M[Unit] = info(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2),
    Formatter[A4, B].format(data4._1, data4._2),
    Formatter[A5, B].format(data5._1, data5._2)
  ).flatMap(output)

  final def warn[A: Formatter[_, B]](
      description: String,
      data: (String, A)
  ): M[Unit]
  final def warn[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit]
  final def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit]
  final def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2)
  ): M[Unit]
  final def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2),
      data5: (String, A2)
  ): M[Unit]
  final def error[A: Formatter[_, B]](
      description: String,
      data: (String, A)
  ): M[Unit]
  def error[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit]
  final def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit]
  final def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2)
  ): M[Unit]
  final def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2),
      data5: (String, A2)
  ): M[Unit]

  def info(details: B*): M[B]
  def warn(details: B*): M[B]
  def error(details: B*): M[B]
  def output(value: B): M[Unit]
}
