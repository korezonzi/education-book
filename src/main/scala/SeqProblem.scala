object SeqProblem {
  def main(args: Array[String]): Unit = {
    println(prob1(numSeq))
    println(prob1_2(numSeq))
    println(prob1Part2(numSeq))
    println(prob2(numSeq))
    println(prob3(Seq(numSeq,numSeq2, numSeq3)))
    println(prob4(numSeq))
    println(prob4(Seq(1,3)))
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
    println(prob9(Seq(1,2)))
    println(prob10(numSeq4))
    println("-----prob11-----")
    println(reverse(numSeq))
    println("12: "+prob12(numSeq))
    //println("13: "+prob13(Seq.empty))
    println("14: "+prob14)
    println("15: "+prob15)

  }

  val numSeq  = Seq(1, 2, 3, 4, 5, 102)
  val numSeq2 = Seq(2, 5)
  val numSeq3 = Seq(1, 8)
  val numSeq4 = Seq(2, 11, 4)

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。
  def prob1(numSeq: Seq[Int]) = {
    for{
      x <- numSeq
    } yield x match {
      case i if(i % 3 == 0) => 0
      case other => other
    }
  }

  def prob1_2(numSeq: Seq[Int]) = {
    numSeq.collect{
      case num if(num  %3 == 0) => 0
      case other                => other
    }
  }
  def prob1Part2(numSeq: Seq[Int]) = {
    numSeq.map(x =>  if( x % 3 == 0) 0 else x)
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
      case None    => -1
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
    strSeq.collect{
      case x if(x.size >= 2) => x + "x"
    }
  }

  def prob7(numSeq: Seq[Int]) = {
    numSeq.filter( _ >= 100) match {
      case x if(x.nonEmpty) => x.collectFirst(_ * 2).getOrElse("")
      case _                => 0
    }
  }

  def prob7_2(numSeq: Seq[Int]) = {
    numSeq.find( _ >= 100).collectFirst(_ * 2).getOrElse(0)
  }

  def prob7_3(numSeq: Seq[Int]) = {
    numSeq.collectFirst {
      case num if(num >= 100) => num * 2
    }.getOrElse(0)
  }



  def prob8(numSeq: Seq[Int])= {
    if(numSeq.isEmpty)0
    else {
      for{
        head <- numSeq.headOption
        last <- numSeq.lastOption
      }yield head + last
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
      case x if(x.size >= 3)                => x.head + x.last
      case y if(y.size >= 1 && y.size <= 2) => 0
      case z if(z.isEmpty)                  => -1
    }
  }

  //Great
  //TODO: 理解
  def prob10_2(numSeq: Seq[Int]) = {
    numSeq match {
      case h +: _  +: _ :+ l => h + l
      case _ +: _            => 0
      case _                 => -1
    }
  }

  def reverse(numSeq: Seq[Any]) = {
    //numSeq.foldLeft(0)((acc, n ) => acc+n)
    numSeq.foldLeft(Seq.empty[Any]){(result, elem) =>
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
    if(numSeq.isEmpty) throw new RuntimeException("empty...")
    else numSeq.reduce{(acc, n) =>
      acc * n
    }
  }

  def prob13_2(numSeq: Seq[Int]) = {
    numSeq.reduce{(acc, n) =>
      acc * n
    }
  }

  def prob14: Int = {
    numSeq.min
  }

  def prob15: Int = {
    numSeq.max
  }
}
