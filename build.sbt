import ReleaseTransformations._

lazy val root = project
  .in(file("."))
  .settings(
    name := "jlogger",
    version := "0.0.1",
    organization := "io.github.sjmyuan",
    scalaVersion := "2.13.7",
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.2.9",
    libraryDependencies += "io.circe" %% "circe-core" % "0.14.1",
    libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.32",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6" % Test,
    crossScalaVersions := Seq("2.13.5", "2.13.6", "2.13.7"),
    ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org",
    addCompilerPlugin(
      "org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full
    ),
    releaseCrossBuild := true,
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepCommand("sonatypeBundleRelease"),
      setNextVersion,
      commitNextVersion,
      pushChanges
    )
  )
