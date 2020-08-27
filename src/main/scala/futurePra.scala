import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

object futurePra {
  def main(args: Array[String]): Unit = {
    futureAwait
    futureComplete
    futureRes
    futureResFlatMap
    //futureFor
    futureFor2
    println(futureFor2)
  }

  def run(): Unit = {
        Future {
      (1 to 10).foreach{i =>
        Thread.sleep(1000)
        println(i)
      }
    }

    Future {
      (11 to 20).foreach { i =>
        Thread.sleep(2000)
        println(i)
      }
    }
  }

  def futureAwait: Unit = {
    val future = Future {
      Thread.sleep(1000)
      2 * 2
    }
    val result  = Await.ready(future, Duration.Inf)
    result.value.get match {
      case Success(value) => println(s"futureAwait = ${value}")
      case Failure(exception) => println(s"futureAwait = ${exception}")
    }
  }
  def futureComplete = {
    val future2  = Future {
      println("Futureの処理開始")
      Thread.sleep(3000)
      println("処理開始")
    }
    future2.onComplete{
      case Success(value)     => println("成功")
      case Failure(exception) => println(s"エラー: + ${exception}")
    }
  }

  def future1: Future[Int] = {
    Future{
      Thread.sleep(1000)
      2*2
    }
  }

  def future2(i: Int): Future[Int] = {
    Future {
      Thread.sleep(1000)
      i * 2
    }
  }

  def future3(i: Int): Future[Unit] = {
    Future {
      Thread.sleep(1000)
      println(s"future3  = ${i*2}")
    }
  }

  //戻り値: Future[Future[]]
  def futureRes = {
    future1.map{ n =>
      future2(n).map{ m =>
        future3(m)
      }
    }
  }
  def futureFutureRes = {
    future1.flatMap {n =>
      future2(n).map {m =>
        future3(m)
      }
    }
  }

  def futureResFlatMap = {
    future1.flatMap{n =>
      future2(n).flatMap{m =>
        future3(m)
      }
    }
  }

  def futureFor = {
    for{
      n <- future1
      m <- future2(n)
      _ <- future3(m)
    }yield {

    }
  }
def futureFor2 = {
    for{
      n <- future1
      m <- future2(n)
      res <- future3(m)
    }yield {
      res
    }
  }
}
