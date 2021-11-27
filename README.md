## jlogger

This is a Scala library to print the log in JSON format

### Installation

Add the following dependency to you `build.sbt`

```scala
  libraryDependencies += "io.github.sjmyuan" %% "jlogger" % "0.0.1",
```

### Example

```scala
import io.github.sjmyuan.jlogger.SimpleJsonLogger
import cats.effect.IO
import cats.effect.IOApp

object App extends IOApp {
    val logger = new SimpleJsonLogger[IO]()

    val program = for {
      _ <-logger.warn("This is a json logger")
      _ <-logger.error("This is a json logger")
      _ <-logger.info("This is a json logger")
    } yield()

    program.unsafeRunSync()
}
```
