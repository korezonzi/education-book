import com.sun.net.httpserver.Authenticator.Failure

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}

val v: Either[String, Int] = Right(100)
//val leftEither : Either[String, Int] =  Left("false...")
//val rightEither: Either[String, Int] = Right(100)


v match {
  case Left(str) => println("not found...")
  case Right(int) => println(s"value is ${int}")
}
v.getOrElse("")

val leftEither: Either[String, Int]= Left("invalid parameter") //
val leftMap = leftEither.map(_ + "to map")
println(leftMap)

val rightMap = v.map(_ * 100)
val leftMapApply = leftEither.left.map(_ + " add map")
val rightMapApply = v.left.map(_ * 100) //return: 100
leftEither.getOrElse("not found..")
v.getOrElse("not found")

//--------Try---------//
Try(None.get)

  val eit1: Either[String, Int] = Right(200)
  val eit2: Either[String, Int] = Left("not found")
  val eit3: Either[String, Int] = Right(100)
  val res = for {
    val1 <- eit1
    x = val1
    val2 <- eit2
    y = val2
    val3 <- eit3
    z = val3
  } yield val1 * val2 * val3
    res.foreach(i => println(i))
//何も出力されない


val res = Success(1).toOption //Some(1)
Try(None.get).toOption  //None

val result: Future[String] = Future{
  Thread.sleep(1000)
  "hello"
}
Await.ready(result, Duration.Inf)
result.value.get match {
  case Success(value) => println("process exit " + value)
  case Failure(exception) => {
    //logger.error("error: "+ exception.getMessage)
    throw exception
  }
}

import EitherTry.UserId

case class User(id: UserId, name: String)
case class ExceptionMessage(message: String)
object LoginApplication {
  def login(id: UserId): Either[String, User] = {
    // implement
    //???
    id match {
      case id if(id == UserId(1)) =>  Right(User(id, "hoge"))
      case x => Left(x.toString)
    }
  }
  val loginRes = login(UserId(2))
  val loginResLeft = loginRes.left
  val loginResLeftMap = loginResLeft.map(s => ExceptionMessage(s))
  val loginResLeftMapRight = loginResLeftMap.right
  val res = loginResLeftMapRight.map(u => u.id)
}
LoginApplication.loginRes
LoginApplication.loginResLeft
LoginApplication.loginResLeftMap
LoginApplication.loginResLeftMapRight
LoginApplication.res

val numsOpt = Seq(Some(2), Some(2),None, Some(9))
val nums    = Seq(1,2,3,4,5,8)
val res1 = numsOpt.groupBy(_.getOrElse(100))
val res2 = nums.groupBy(_ % 2 == 0)

val users = Seq(
  User(UserId(1), "taro"),
  User(UserId(2),"lll"),
  User(UserId(3), "taro")
)
users.groupBy(_.name)