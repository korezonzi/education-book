import java.time.LocalDate

object SeqProblem {
  def main(args: Array[String]): Unit = {
    println(prob1(numSeq))
    println(prob1_2(numSeq))
    println(prob1Part2(numSeq))
    println(prob2(numSeq))
    println(prob3(Seq(numSeq, numSeq2, numSeq3)))
    println(prob4(numSeq))
    println(prob4(Seq(1, 3)))
    println(prob5(Seq(Some(1), Some(0))))
    println(prob5(Seq(Some(1), None)))
    println("------prob6 start-------")
    println(prob6(Seq("opton", "a", "hoge")))
    println(prob7(numSeq))
    println(prob7_2(numSeq))
    println(prob7_3(numSeq))
    println(prob7(numSeq4))
    println(prob8(numSeq))
    println(prob9(numSeq))
    println(prob9(Seq(1, 2)))
    println(prob10(numSeq4))
    println("-----prob11-----")
    println(reverse(numSeq))
    println("12: " + prob12(numSeq))
    //println("13: "+prob13(Seq.empty))
    println("14: " + prob14)
    println("15: " + prob15)
    println(extraProb1(strSeq))
    println(extraProb1(Seq("")))
    println(extraProb2(numSeq))
    println(extraProb3(numSeq))
    println(extraProb4(numSeq))
    println(getTotalRanking(scores))
  }

  val numSeq = Seq(1, 2, 3, 4, 5, 102)
  val numSeq2 = Seq(2, 5)
  val numSeq3 = Seq(1, 8)
  val numSeq4 = Seq(2, 11, 4)
  val strSeq: Seq[String] = Seq("し", "な", "て", "も", "お")


  // Seq 応用問題
  case class Score(
    name:    String,    // 学生の名前
    english: Int,       // 英語の点数
    math:    Int,       // 数学の点数
    science: Int,       // 理科の点数
    date:    LocalDate  // 受験日
  )

  // Seq 応用問題
  val scoreOfAlice   = Score(name = "Alice",   english = 77,  math = 74, science = 26, date = LocalDate.of(2020, 1, 30))
  val scoreOfBob     = Score(name = "Bob",     english = 100, math = 74, science = 14, date = LocalDate.of(2020, 1, 26))
  val scoreOfCharlie = Score(name = "Charlie", english = 100, math = 74, science = 99, date = LocalDate.of(2020, 1, 26))
  val scoreOfDave    = Score(name = "Dave",    english = 50,  math = 81, science = 88, date = LocalDate.of(2020, 1, 30))
  val scores: Seq[Score] = Seq(scoreOfAlice, scoreOfBob, scoreOfCharlie, scoreOfDave)

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。
  def prob1(numSeq: Seq[Int]) = {
    for {
      x <- numSeq
    } yield x match {
      case i if (i % 3 == 0) => 0
      case other => other
    }
  }

  def prob1_2(numSeq: Seq[Int]) = {
    numSeq.collect {
      case num if (num % 3 == 0) => 0
      case other => other
    }
  }

  def prob1Part2(numSeq: Seq[Int]) = {
    numSeq.map(x => if (x % 3 == 0) 0
    else x
    )
  }

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion2メソッドがあります。 numSeqのうち3の倍数のみを返すメソッドをfilterを使って作成してください。
  def prob2(numSeq: Seq[Int]) = {
    numSeq.filter(_ % 3 == 0)
  }

  //Seq[Seq[Int]]型である、numSeqSeqが引数として渡されるseqQuestion3メソッドがあります。 numSeqSeqのうち3の倍数を含むSeqのみを返すメソッドをfilterとexistsを使って作成してください。
  def prob3(numSeqSeq: Seq[Seq[Int]]) = {
    numSeqSeq.filter(_.exists(_ % 3 == 0))
  }

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion4メソッドがあります。 numSeqに偶数が含まれていればその最初の値を、含まれていない場合は-1を返すメソッドをfindを使って作成してください。
  def prob4(numSeq: Seq[Int]) = {
    numSeq.find(_ % 2 == 0) match {
      case Some(x) => x
      case None => -1
    }
  }

  def prob4Part2(numSeq: Seq[Int]) = {
    numSeq.find(_ % 2 == 0).getOrElse(-1)
  }

  //Seq[Option[Int]]型である、numOptSeqが引数として渡されるseqQuestion5メソッドがあります。 numOptSeqのうち0を含む最初のOption[Int]を返すメソッドをfindとcontainsを使って作成してください。
  def prob5(numOptSeq: Seq[Option[Int]]) = {
    numOptSeq.find(_.contains(0)).flatten
  }

  //Seq[String]型である、strSeqが引数として渡されるseqQuestion6メソッドがあります。 strSeqのうち文字列の長さが2以上であるものの末尾に"x”を追加し、それらのみを含むSeqを返すメソッドを、collectを使って作成してください。
  def prob6(strSeq: Seq[String]) = {
    strSeq.collect {
      case x if (x.size >= 2) => x + "x"
    }
  }

  def prob7(numSeq: Seq[Int]) = {
    numSeq.filter(_ >= 100) match {
      case x if (x.nonEmpty) => x.collectFirst(_ * 2).getOrElse("")
      case _ => 0
    }
  }

  def prob7_2(numSeq: Seq[Int]) = {
    numSeq.find(_ >= 100).collectFirst(_ * 2).getOrElse(0)
  }

  def prob7_3(numSeq: Seq[Int]) = {
    numSeq.collectFirst {
      case num if (num >= 100) => num * 2
    }.getOrElse(0)
  }


  def prob8(numSeq: Seq[Int]) = {
    if (numSeq.isEmpty) 0
    else {
      for {
        head <- numSeq.headOption
        last <- numSeq.lastOption
      } yield head + last
    }.getOrElse("")
  }

  def prob8_2(numSeq: Seq[Int]) = {
    for {
      head <- numSeq.headOption
      last <- numSeq.lastOption
    } yield head + last
  }.getOrElse(0)

  def prob9(numSeq: Seq[Int]): Seq[Int] = {
    //if(numSeq.length < 3) return List(): Seq[Int]
    numSeq.init.tail
  }

  def prob10(numSeq: Seq[Int]): Int = {
    numSeq match {
      case x if (x.size >= 3) => x.head + x.last
      case y if (y.size >= 1 && y.size <= 2) => 0
      case z if (z.isEmpty) => -1
    }
  }

  //Great
  //TODO: 理解
  def prob10_2(numSeq: Seq[Int]) = {
    numSeq match {
      case h +: _ +: _ :+ l => h + l
      case _ +: _ => 0
      case _ => -1
    }
  }

  def reverse(numSeq: Seq[Any]) = {
    //numSeq.foldLeft(0)((acc, n ) => acc+n)
    numSeq.foldLeft(Seq.empty[Any]) { (result, elem) =>
      elem +: result
    }
  }

  def prob12(numSeq: Seq[Int]) = {
    numSeq.foldRight(1) { (num, acc) =>
      num * acc
    }
  }

  //product: 全要素を掛け合わせる
  //numSeq.product

  def prob13(numSeq: Seq[Int]) = {
    if (numSeq.isEmpty) throw new RuntimeException("empty...")
    else numSeq.reduce { (acc, n) =>
      acc * n
    }
  }

  def prob13_2(numSeq: Seq[Int]) = {
    numSeq.reduce { (acc, n) =>
      acc * n
    }
  }

  def prob14: Int = {
    numSeq.min
  }

  def prob15: Int = {
    numSeq.max
  }

  /*問題1 文字列の配列、strSeqが与えられます。※ seqの定義は以下
    val strSeq: Seq[String] = Seq("し", "な", "て", "も", "お")
    foldLeftを使って、"おもてなし"(型はString)という文字列を作成してください。(他に必要なメソッドがあれば、使用しても構わない)*/
  def extraProb1(strSeq: Seq[String]) = {
    strSeq.foldLeft("") { (acc, str) =>
      (str +: acc).mkString("")
    }
  }

  def extraProb1_2(strSeq: Seq[String]) = {
    strSeq.foldLeft(Seq.empty[String]) { (acc, str) =>
      str +: acc
    }
  }

  /*問題2: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
  reduce もしくは reduceOptionを使って、intSeqの中身を合計する処理を作成してください。(配列が空の場合には、0を返すこと)*/
  def extraProb2(intSeq: Seq[Int]) = {
    if (intSeq.isEmpty) 0
    else {
      intSeq.reduce { (acc, n) =>
        acc + n
      }
    }
  }

  def extraProb2_2(intSeq: Seq[Int]) = {
    intSeq.reduceOption { (acc, num) =>
      acc + num
    }.getOrElse(0)
  }

  /*問題3: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
  collectを使って、1の場合には"x"を、2の場合には"y"を、それ以外の場合には"z"に変換し配列を返す処理を作成してください。*/
  def extraProb3(intSeq: Seq[Int]) = {
    if (intSeq.isEmpty) Seq.empty
    else {
      intSeq.collect {
        case 1 => "x"
        case 2 => "y"
        case _ => "z"
      }
    }
  }

  /*ちょっと発展
  問題4: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1*1, 2*2, 4*4, 3*3) もしくは Seq()
  reduceOptionを使って、intSeqの最大値を算出する処理を作成してください。(配列が空の場合は、0を返すこと)*/
  def extraProb4(intSeq: Seq[Int]) = {
    if (intSeq.isEmpty) 0
    else {
      intSeq.reduceOption { (acc, n) =>
        if (acc <= n) n
        else acc
      }
    }.getOrElse(0)
  }

  //TODO
  //抑える
  def getTotalRanking(scoreSeq: Seq[Score]): Seq[String] = {
    scoreSeq.sortBy(score =>
      score.english + score.math + score.science
    ).reverse.map(_.name)
  }
}