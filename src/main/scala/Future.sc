import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

// x/1s: 1~10
// y/2s: 11~20
//def printNum (): Unit = {
//  (1 to 10).foreach{i =>
//    Thread.sleep(1000)
//    println(i)
//  }
//
//  (11 to 20).foreach{ i =>
//    Thread.sleep(2000)
//    println(i)
//  }
//}
//printNum()
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def futureNum() = {
  Future {
    for{i <- 1 to 10}yield {
      Thread.sleep(10)
      println(i)
    }
  }
  Future {
    for{i <- 11 to 20}yield {
      Thread.sleep(20)
      println(i)
    }
  }
}
futureNum()
Await.ready(futureNum(), Duration.Inf)
println("----")

//val future  = Future(1)
val  suc = Future.successful(2)
val aa = Future("hoge")

//わざとエラー出してる
//val  fai = Future.failed(throw new NoSuchElementException)

val futAwait = Future {
  Thread.sleep(1000)
  2*2
}
val result = Await.ready(futAwait, Duration.Inf)
val future1 = Future{
  Thread.sleep(1000)
  2 * 2
}

val futureRec = Future {
  println("futureの処理開始")
  Thread.sleep(1)
  1 / 0
}
//futureRec.recover {
//  case e: Exception => println("エラー発生")
//}
//futureRec.recoverWith {
//  case e: Exception => Future .successful("recover")
//}
val a = Await.ready(futureRec, Duration.Inf)
 a.recover {
  case e: Exception => println("エラー発生")
}
 a.recoverWith {
  case e: Exception => Future .successful("recover")
}
