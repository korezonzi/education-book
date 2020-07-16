import java.time.LocalDate

object SeqExtraProblem {
  def main(args: Array[String]): Unit = {
    println(getTotalRanking(scores))
  }

  //型定義
  case class Score(
    name: String,
    english: Int,
    math: Int,
    science: Int,
    date: LocalDate
  )

  //変数定義
  val scoreOfAlice       = Score(name = "Alice", english = 77, math = 74, science = 26, date = LocalDate.of(2002, 1, 30))
  val scoreOfBob         = Score(name = "Bob", english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26))
  val scoreOfCharlie     = Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26))
  val scoreOfDave        = Score(name = "Dave", english = 50, math = 81, science = 88, date = LocalDate.of(2020, 1, 30))
  val scores: Seq[Score] = Seq(scoreOfAlice, scoreOfBob, scoreOfCharlie, scoreOfDave)

  //prob1
  def getTotalRanking(scoreSeq: Seq[Score]) = {
    /*for {
      score   <- scoreSeq
      english <- score.english
      math    <- score.math
      science <- score.science
    }   yield score*/
    //学生名だけ抜き出すのか。。。
    scoreSeq.sortBy(score => score.science + score.math + score.english)(Ordering.Int.reverse)
  }

  //prob2
  //val nullsLastOptionStringOrdering
}