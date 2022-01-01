package io.github.sjmyuan.jlogger

import munit.FunSuite
import io.circe.syntax._
import cats.implicits._
import JsonInstances._
import io.circe.Json

class JsonMonoidSpec extends FunSuite {
  test("can combine the list of Json") {
    val attributes: List[Json] = List(
      Json.obj("key1" -> "1".asJson),
      Json.obj("key2" -> "2".asJson),
      Json.obj("key3" -> "3".asJson)
    )

    val expected =
      Json.obj("key1" -> "1".asJson, "key2" -> "2".asJson, "key3" -> "3".asJson)

    assertEquals(attributes.combineAll, expected)
  }
}
