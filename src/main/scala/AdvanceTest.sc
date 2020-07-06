import scala.concurrent.Future
import scala.util.{Failure, Success}

//def convertToString(numOpt: Option[Int])(conv: Option[Int] => String): String = conv(numOpt)
//def question2(numOpt: Option[Int]): String = {
//  numOpt match {
//    case Some(x) => convertToString(numOpt).toString()
//    case None    => convertToString(None).toString()
//  }
//}

//回答例
def convertToString(numOpt: Option[Int])(conv: Option[Int] => String): String = conv(numOpt)
def question2_1(numOpt: Option[Int]): String = {
  convertToString(numOpt)(numOpt => numOpt match {
    case Some(v) => v.toString
    case None    => "空でした"
  })
}
def question2(numOpt: Option[Int]) = {
  numOpt.map(_.toString).getOrElse("空でした")
}
println(question2(Some(3)))

//Q3
//Seq[Int]型であるnumsを引数として受け取り、配列の中身を昇順でソートするquesion3を作成してください
def question3(nums: Seq[Int]) = {
  nums.sorted
}

//×Q4
//Seq[Int]型であるnumsを引数として受け取り、配列の中身を降順でソートするquesion4を作成してください。その際にreverseメソッドは使用しないこと
def question4(nums: Seq[Int]) = {
  nums.sortWith((num, numNext) => num > numNext)
}

//Q5
//Seq[Option[Int]]型である、numOpsを引数にとりnumOpsの要素がSomeの場合は中の数字を、Noneの場合はリストから外したSeq[Int]を返すquestion5を作成してください
val numsOpt = Seq(Some(3), Some(5), None)
numsOpt.flatten
for{
  Some(x) <- numsOpt
}yield x

//6
val nums = Seq(2,5,1,5)
nums.zipWithIndex

//7
nums.zipWithIndex.max
nums.indexOf(nums.max)

//8
nums.distinct

//9
case class Article(
  id:    Long,
  title: String,
  body:  String
)
case class ArticleDetail(
  articleId: Long,
  category:  String
)
val articles: Seq[Article] =
  Seq(
    Article(1, "フロント", "html, cssの修正"),
    Article(2, "バック", "Scalaだよ"),
    Article(3, "インフラ", "AWS")
  )
val articlesDetail: Seq[ArticleDetail] =
  Seq(
    ArticleDetail(1, "done"),
    ArticleDetail(2, "done"),
  )
//for{
//  arti     <- articles
//  arDetal <- articlesDetail
//  x <- if(arDetal.articleId == arti.id) arti
//  y <- if(arDetal.articleId == arti.id) arDetal
//} yield (x,y)

for{
  at <- articles
  ad <- articlesDetail
} yield (at, ad)

articles.map(x => (x, articlesDetail.find(_.articleId == x.id)))
//Map(1 -> AD(1,done), ...)
val articleDetailMap = articlesDetail.map(x => (x.articleId, x)).toMap
//
articles.map(x => (x, articleDetailMap.get(x.id)))

//10
val set1 = Set(1,2,2,3)
val set2 = Set(3,5,8)
set1.union(set2)
set1.diff(set2)

case class Person(
  id: Long,
  name: String,
  gender: Option[String]
)

val people = Seq(
  Person(1, "太郎", Some("male")),
  Person(2, "Rin", Some("female")),
  Person(3, "Pochi", None)
)
people.map(x => Person(x.id, x.name, None))
people.map(_.copy(gender = None))

//12
val numStr = "1,2,3,hello,4"
val numStrSeq =  numStr.split(",").map(_.toIntOption)

/*.collect{
  case x if()

/* => Some(x)
  case _       => None
}*/*/

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
//val fOptStr: Future[Option[String]] = Future(Some("ほげ"))
val fOptStr: Future[Option[String]] = Future(None)
fOptStr.onComplete{
  case Success(value) => value match {
    case Some(x) => println(s"Someの時は: ${x}")
    case None    => println("なし")
  }
  case Failure(exception) => println("失敗")
}
for{
  optStr <- fOptStr
}yield optStr match {
  case Some(x) => println(x)
  case None    => println("なし")
}

//14
val fEith: Future[Either[Int, String]] = Future(Right("成功"))
val fEithL: Future[Either[Int, String]] =Future(Left(11))
for{
  eith <- fEith
} yield {
  eith match {
    case Right(x) => println(x)
    case Left(x)  => println(x)
  }
}

//ばつ
//15
val numsFutu: Seq[Future[Int]] = Seq(Future(1), Future(2), Future(5))
numsFutu.foldLeft(Future.successful(0)) {(acc, v) =>
  for {
    v1 <- acc
    v2 <- v
  }yield {
    (v1+v2)
  }
}