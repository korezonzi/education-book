import scala.util.{Failure, Success, Try}

object EitherTry {
  def main(args: Array[String]): Unit = {
    println(prob3())
    println(LoginApplication.loginRes)
    //println(LoginApplication.leftType)
    println(LoginApplication.rightType)
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
    println(loginRes)
    val leftType = loginRes.left.map(ExceptionMessage)
    println(leftType)
    val rightType = loginRes.right.map(_.id)
    println(rightType)
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

  def prob3_2: Either[String, Int] = {
    val intTry = Try("100".toInt)
    intTry.toEither.left.map(_.getMessage)
  }

  //prob4
  //fold: Leftと Right の値を変ん関して、値を取り出すことが出来る
  //Leftの値 'b:B' は'fb: B => C'によって変換される
  //Rightの値 'a: A' は 'fa:A => C'によって変換される
  val intTry = Try("100".toInt)
  val strIntEither = intTry.toEither.left.map(_.getMessage)
  strIntEither.fold(
    l => println("ExceptionMessage :" + l),
    r => println("Success " + r)
  )

  //prob5
  //toOption: Failure -> None, Success(v) -> Some(v)
  val res = Success(1).toOption //Some(1)
  Try(None.get).toOption  //None

  val userTom = User(UserId(1), "tom")
  //先にLeftになっていると後続の処理は実行されない
  /*def updateUser(id: UserId, name: String) = {
    val result : Either[Error, User] = for{
      //1. User情報の取得
      user <- userTom
    }
  }*/
}
