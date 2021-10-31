package com.sjmyuan.logger

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import JsonLogger._

class JsonLoggerSpec extends munit.FunSuite {
  val logger = new JsonLogger[IO]()
  test("can print info log with json format") {
    logger.info("test the log", "info1" -> 1, "info2" -> (1, 2)).unsafeRunSync()
  }
  test("can print warn log with json format") {
    logger.warn("test the log", "info1" -> 1, "info2" -> (1, 2)).unsafeRunSync()
  }
  test("can print error log with json format") {
    logger
      .error("test the log", "info1" -> 1, "info2" -> (1, 2))
      .unsafeRunSync()
  }
}
