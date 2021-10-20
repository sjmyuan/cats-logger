val scala3Version = "3.0.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "cats-logger",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.2.9",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    ThisBuild / scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) => Seq("-Ykind-projector:underscores")
        case Some((2, 13)) | Some((2, 12)) =>
          Seq("-Xsource:3", "-P:kind-projector:underscore-placeholders")
      }
    }
  )
