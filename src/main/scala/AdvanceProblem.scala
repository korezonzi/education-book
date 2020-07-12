import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}

object AdvanceProblem {
  def main(args: Array[String]): Unit = {
    println(question1(Some(8)))
    println(question2(Some(3)))
    println(question3(nums))
    println(question4(nums))
    println(question5(numsOpt))
    println(question5_2(numsOpt))
    println(question6(nums))
    println(question7(nums))
    println(question7_2(nums))
    println(question8(nums))
    println(question9(articles, articlesDetail))
    question10(Set(1,2,3,4), Set(3,4,5,6,6))
    println(question11(people))
    println(question11_2(people))
    println(question12(numStr))
    question13(fOptStr)
    question13(fNoneStr)
    question13_2(fOptStr)
    question13_2(fNoneStr)
    question14(fEithR)
    question14(fEithL)
    question15(numsFuture)
  }
  val nums    = Seq(3, 5, 1, 0)
  val numsOpt = Seq(Some(3), Some(1), None, Some(10))
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
  val people = Seq(
    Person(1, "太郎", Some("male")),
    Person(2, "Rin", Some("female")),
    Person(3, "Pochi", None)
  )
  val numStr = "1,2,3,hello,4"
  val fOptStr = Future(Some("ほげ"))
  val fNoneStr = Future(None)
  val fEithR  = Future(Right("成功"))
  val fEithL  = Future(Left(199))
  val numsFuture: Seq[Future[Int]] = Seq(Future(1), Future(2), Future(5))

  //Q1
  //Option[Int]型の numOptを引数として受け取り
  //numOptがSomeでかつ値が10以上であれば、"A"
  //numOptがSomeでかつ値が9以下、5以上であれば、"B"
  //numOptがSomeでかつ値が4以下であれば"C"
  //numOptがNoneであれば"D"
  //を標準出力させるメソッドquestion1を作成してください
  def question1(numOpt: Option[Int]) = {
    numOpt match {
      case Some(x) if(x >= 10)           => "A"
      case Some(y) if(y >= 5 && y <= 9 ) => "B"
      case Some(z) if(z <= 4)            => "C"
      case None                          => "D"
    }
  }

  //Q2
  //Option[Int] => String に変換する関数 convと、Option[Int]型である numOpt を引数にとり、numOptを文字列にして返すメソッドconvertToStringがあります。convertToStringを使ってnumOpt: Option[Int]をStringに変換するメソッドquestion2を作成してください。
  //numOptは以下の条件に従って変換させること
  //     1.numOptがSome()であれば、そのIntの値をStringに変換する
  //     2.numOptがNoneであれば、"空でした"というStringに変換する
  //
  def question2(numOpt: Option[Int]) = {
    numOpt.map(_.toString).getOrElse("空でした")
  }

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
  def question5(numOpt: Seq[Option[Int]]) =  {
    numOpt.flatten
  }

  def question5_2(numOpt: Seq[Option[Int]]) =  {
   for{
     Some(x) <- numOpt
   }yield x
  }

  def question6(nums: Seq[Int]) = {
    nums.zipWithIndex
  }

  def question7(nums: Seq[Int]) = {
    nums.zipWithIndex.max
  }

  def question7_2(nums: Seq[Int]) = {
    nums.indexOf(nums.max)
  }

  def question8(nums: Seq[Int]) = {
    nums.distinct
  }

  case class Article(
    id:    Long,
    title: String,
    body:  String
  )
  case class ArticleDetail(
    articleId: Long,
    category:  String
  )
  def question9(articles: Seq[Article], articleDetails: Seq[ArticleDetail] )=  {
    articles.map(x => articleDetails.find(_.articleId == x.id))
  }

  //10
  def question10(set1: Set[Int], set2: Set[Int]) = {
    println("差集合は"+ set1.diff(set2))
    println("和集合は"+ set1.union(set2))
  }

  //11
  case class Person(
    id: Long,
    name: String,
    gender: Option[String]
  )

  //11
  def question11(people: Seq[Person]) = {
    people.map(x => Person(x.id, x.name, None))
  }
  def question11_2(people: Seq[Person]) = {
    people.map(_.copy(gender = None))
  }

  //12
  def question12(numStr: String) = {
    numStr.split(",").map(_.toIntOption)
  }

  def question12_2(numStr: String) = {
    numStr.split(",").map(x =>
      Try(x.toInt).toOption
    )
  }

  //13
  def question13(fOptStr: Future[Option[String]]) = {
    fOptStr.onComplete{
      case Success(value) => value match {
        case Some(x) => println(s"onComplete : ${x}")
        case None    => println("なしだ")
      }
      case Failure(exception) => println(s"エラー: ${exception}")
    }
  }

  def question13_2(fOptStr: Future[Option[String]]) = {
    for {
      optStr <- fOptStr
    } yield {
      optStr match {
        case Some(x) => println(x)
        case None    => println("なしNormal")
      }
    }
  }

  //14
  def question14(fEith: Future[Either[Int, String]]) = {
    for {
      eith <- fEith
    } yield {
      eith match {
        case Right(x) => println(x)
        case Left(x)  => println(x)
      }
    }
  }

  //ばつ
  //15
  def question15(numsFuture: Seq[Future[Int]]) = {
    numsFuture.foldLeft(Future.successful(0)) {(acc, n) =>
      for {
        v1 <- acc
        v2 <- n
      }yield  {
        v1+v2
      }
    }
  }

}