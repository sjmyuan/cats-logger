package com.sjmyuan.logger

import cats.implicits._
import cats.Monad
trait Logger[M[_]: Monad, B] {
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
  ): M[Unit] = warn(Formatter[A, B].format(data._1, data._2)).flatMap(output)

  final def warn[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit] = warn(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2)
  ).flatMap(output)

  final def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit] = warn(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2)
  ).flatMap(output)

  final def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4)
  ): M[Unit] = warn(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2),
    Formatter[A4, B].format(data4._1, data4._2)
  ).flatMap(output)

  final def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4),
      data5: (String, A5)
  ): M[Unit] = warn(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2),
    Formatter[A4, B].format(data4._1, data4._2),
    Formatter[A5, B].format(data5._1, data5._2)
  ).flatMap(output)

  final def error[A: Formatter[_, B]](
      description: String,
      data: (String, A)
  ): M[Unit] = error(Formatter[A, B].format(data._1, data._2)).flatMap(output)

  final def error[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit] = error(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2)
  ).flatMap(output)

  final def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3)
  ): M[Unit] = error(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2)
  ).flatMap(output)

  final def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4)
  ): M[Unit] = error(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2),
    Formatter[A4, B].format(data4._1, data4._2)
  ).flatMap(output)

  final def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[
    _,
    B
  ], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A3),
      data4: (String, A4),
      data5: (String, A5)
  ): M[Unit] = error(
    Formatter[A1, B].format(data1._1, data1._2),
    Formatter[A2, B].format(data2._1, data2._2),
    Formatter[A3, B].format(data3._1, data3._2),
    Formatter[A4, B].format(data4._1, data4._2),
    Formatter[A5, B].format(data5._1, data5._2)
  ).flatMap(output)

  def info(details: B*): M[B]
  def warn(details: B*): M[B]
  def error(details: B*): M[B]
  def output(value: B): M[Unit]
}
