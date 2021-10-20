trait Formatter[A] {
  def format(v: A): String
}

trait Logger[M[_]] {
  def info[A: Formatter](description: String, data: (String, A)): M[Unit]
  def info[A1: Formatter, A2: Formatter](
      description: String,
      data1: (String, A1),
      data2: (String, A2)
  ): M[Unit]
}
