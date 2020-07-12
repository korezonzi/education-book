import java.time.LocalDate

val numSeq = Seq(4, 6, 1, 2, 5)
val charSeq = Seq("a", "o", "a", "i", "b")
numSeq.sorted
charSeq.sorted
numSeq.sorted(Ordering.Int.reverse)

case class Score(
  name:    String,
  english: Int,
  math:    Int,
  science: Int,
  date:    LocalDate
)

val scoreOfAlice   = Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2002, 1, 30))
val scoreOfBob     = Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26))
val scoreOfCharlie = Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26))
val scoreOfDave    = Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30))
val scores: Seq[Score] = Seq(scoreOfAlice, scoreOfBob, scoreOfCharlie, scoreOfDave)

scores.sortBy(_.science)
//-つける: 昇順に並び替え
scores.sortBy(score => -score.english)
//-と同じ値(昇順)で返す
//暗黙のパラメーター
scores.sortBy(_.english)(Ordering.Int.reverse)
//タプル: 複数キーでのソートがされる
//<- 先頭の数字が同じ: 2番目の数字で比較するetc...
scores.sortBy(score => (-score.math, -score.english))
//上と同じ:昇順
scores.sortBy(score => (score.math, score.english, score.science))(Ordering.Tuple3(Ordering.Int.reverse, Ordering.Int.reverse, Ordering.Int.reverse))
println(scoreOfAlice.english)
//LocalDateで古い順にできる
scores.sortWith((scoreA, scoreB) => scoreA.date.isBefore(scoreB.date))

//練習としてOrdered[T]をミックスインしてcompareメソッドを実装
case class OrderedScore(
  name:    String,
  english: Int,
  math:    Int,
  science: Int,
  date:    LocalDate
) extends Ordered[OrderedScore] {
  self =>
  def compare(that: OrderedScore): Int = {
    if(this.math == that.math) {
      if(this.english == that.english) {
        if(this.science == that.science) 0
        else if(this.science > that.science) -1
        else 1
      }
      else if (this.english > that.english) -1
      else 1
    }
    else if (this.math > that.math) -1
    else 1
  }
}


val scoreOfAlice2   = OrderedScore(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2002, 1, 30))
val scoreOfBob2     = OrderedScore(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26))
val scoreOfCharlie2 = OrderedScore(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26))
val scoreOfDave2    = OrderedScore(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30))
val scores2: Seq[OrderedScore] = Seq(scoreOfAlice2, scoreOfBob2, scoreOfCharlie2, scoreOfDave2).sorted

//Ordering.by(x, y): x= ソートしたい型, y = 返還後のソート出来る型
val scienceScoreOrdering: Ordering[Score] = Ordering.by[Score, Int](_.science).reverse
val dateScoreOrdering = Ordering.fromLessThan[Score]((scoreA, scoreB) => scoreA.date.isBefore(scoreB.date))

val myOrdering: Ordering[Score] = new Ordering[Score] {
  def compare(x: Score, y: Score): Int = {
    Ordering.Tuple3(Ordering.Int.reverse, Ordering.Int.reverse, Ordering.Int.reverse).compare (
      (x.math, x.english, x.science),
      (y.math, y.english, y.science)
    )
  }
}

//Map(groupByの型, 中身)に変換される
scores.groupBy(_.date)
//Mapの値を取り出す時: .keys or.values
//もちろんmapでも取り出せる
scores.groupBy(_.date).filter(_._1 == LocalDate.of(2020,1,30)).values