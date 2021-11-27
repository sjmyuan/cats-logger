publishMavenStyle := true

licenses := Seq(
  "MIT" -> url("https://github.com/sjmyuan/jlogger/blob/master/LICENSE")
)

import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(
  GitHubHosting("sjmyuan", "jlogger", "shangjiaming.yuan@gmail.com")
)

developers := List(
  Developer(
    id = "sjmyuan",
    name = "sjmyuan",
    email = "shangjiaming.yuan@gmail.com",
    url = url("https://blog.shangjiaming.com")
  )
)
