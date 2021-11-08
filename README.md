## Json Logger

This is a Scala library to print the log in Json format

### Example

```scala
import com.sjmyuan.logger.SimpleJsonLogger
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
