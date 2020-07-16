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