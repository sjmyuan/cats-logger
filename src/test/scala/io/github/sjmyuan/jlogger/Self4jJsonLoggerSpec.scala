package io.github.sjmyuan.jlogger

import munit.FunSuite
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.slf4j.LoggerFactory

class Self4jJsonLoggerSpec extends FunSuite {

  val logger = new Self4jJsonLogger[IO](LoggerFactory.getLogger(getClass()))

  test("can print info log") {
    logger.info("a test for self4j", "attr1" -> 1, "attr2" -> 2).unsafeRunSync()
  }
  test("can print warn log") {
    logger.warn("a test for self4j", "attr1" -> 1, "attr2" -> 2).unsafeRunSync()
  }
  test("can print error log") {
    logger
      .error("a test for self4j", "attr1" -> 1, "attr2" -> 2)
      .unsafeRunSync()
  }

}
