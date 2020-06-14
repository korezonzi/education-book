import scala.util.{Failure, Success, Try}

object EitherTry {
  def main(args: Array[String]): Unit = {
    println(prob3())
//    println(LoginApplication.loginRes)
//    println(LoginApplication.leftType)
//    println(LoginApplication.rightType)
  }

  //回答
  //val prob1: Either[ ExceptionMessage, UserId]
  case class UserId(id: Long)
  case class User(id: UserId, name: String)
  case class ExceptionMessage(message: String)
  object LoginApplication {
    def login(id: UserId): Either[String, User] = {
      ???
    }
    val loginRes = login(UserId(1))
    val leftType = loginRes.left.map(ExceptionMessage)
    val rightType = loginRes.right.map(_.id)
  }

  //prob2
  //  200 <-
  //  for はいらない
  //  100
  //yield 20000(=200 * 100)
  val eit1: Either[String, Int] = Right(200)
  val eit2: Either[String, Int] = Left("not found")
  val eit3: Either[String, Int] = Right(100)
  val v = for {
    val1 <- eit1
    val2 <- eit2
    val3 <- eit3
  } yield val1 * val2 * val3
  v.foreach(i => println(i))

  //prob3
  def prob3(): Either[String, Int] = {
    val res: Try[Int] = Success(1)
    res match {
      case Success(x)         => Right(x)
      case Failure(exception) => Left(exception.getMessage)
    }
  }
}
