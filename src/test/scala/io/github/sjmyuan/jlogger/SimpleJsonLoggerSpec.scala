package io.github.sjmyuan.jlogger

import cats.effect.IO
import cats.effect.unsafe.implicits.global

class SimpleJsonLoggerSpec extends munit.FunSuite {
  val logger = new SimpleJsonLogger[IO]()
  // test("content contain the log level, time and custom attributes") {
  //   val now = Instant.parse("2006-01-01T00:00:00Z")
  //   val content = logger.generateContent(
  //     LogLevel.INFO,
  //     now,
  //     List(Json.obj("test" -> "haha".asJson))
  //   )
  //   val expected = Json.obj(
  //     "level" -> "INFO".asJson,
  //     "time" -> "2006-01-01T00:00:00Z".asJson,
  //     "test" -> "haha".asJson
  //   )

  //   assertEquals(content, expected)
  // }

  test("can print info log with json format") {
    logger
      .info("test the log", "info1" -> 1, "info2" -> ((1, 2)))
      .unsafeRunSync()
  }
  test("can print info with same type attribute") {
    logger.info("test the log", "info1" -> 1, "info2" -> 2).unsafeRunSync()
  }
  test("can print warn log with json format") {
    logger
      .warn("test the log", "info1" -> 1, "info2" -> ((1, 2)))
      .unsafeRunSync()
  }
  test("can print error log with json format") {
    logger
      .error("test the log", "info1" -> 1, "info2" -> ((1, 2)))
      .unsafeRunSync()
  }
}
