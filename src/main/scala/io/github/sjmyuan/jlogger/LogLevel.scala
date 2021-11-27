package io.github.sjmyuan.jlogger

sealed trait LogLevel

object LogLevel {
  case object INFO extends LogLevel
  case object WARNING extends LogLevel
  case object ERROR extends LogLevel
}
