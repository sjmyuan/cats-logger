import cats.kernel.Monoid
trait Formatter[A, B] {
  def format(key: String, value: A): B
}

trait Logger[M[_], B] {
  def info[A: Formatter[_, B]](description: String, data: (String, A)): M[Unit]
  def info[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit]
  def info[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
      data3: (String, A3)
  ): M[Unit]
  def info[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2)
  ): M[Unit]
  def info[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2),
      data5: (String, A2)
  ): M[Unit]
  def warn[A: Formatter[_, B]](description: String, data: (String, A)): M[Unit]
  def warn[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit]
  def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
      data3: (String, A3)
  ): M[Unit]
  def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2)
  ): M[Unit]
  def warn[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2),
      data5: (String, A2)
  ): M[Unit]
  def error[A: Formatter[_, B]](description: String, data: (String, A)): M[Unit]
  def error[A1: Formatter[_, B], A2: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit]
  def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
      data3: (String, A3)
  ): M[Unit]
  def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B], A4: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2)
  ): M[Unit]
  def error[A1: Formatter[_, B], A2: Formatter[_, B], A3: Formatter[_, B], A4: Formatter[_, B], A5: Formatter[_, B]](
      description: String,
      data1: (String, A1),
      data2: (String, A2),
      data3: (String, A2),
      data4: (String, A2),
      data5: (String, A2)
  ): M[Unit]

  def info(details:B*):M[Unit]
  def warn(details:B*):M[Unit]
  def error(details:B*):M[Unit]
}
