package com.sjmyuan.logger

trait Formatter[A, B] {
  def format(key: String, value: A): B
}

object Formatter {
  def apply[A, B](implicit formatter: Formatter[A, B]): Formatter[A, B] =
    formatter
}
