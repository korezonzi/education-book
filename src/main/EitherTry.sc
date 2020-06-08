import scala.util.Try

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