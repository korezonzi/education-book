object SeqProblem {
  def main(args: Array[String]): Unit = {
    println(prob1(Seq(1,2,3,4,5, 6)))
    println(prob2(Seq(1,2,3,4,5, 6)))
    println(prob3(Seq(Seq(2,3,5),Seq(1,2), Seq(1,3))))
    println(prob4(Seq(1,2,3)))
    println(prob4(Seq(1,3)))
    println(prob5(Seq(Some(1), Some(0))))
    println(prob5(Seq(Some(1), None)))
    println("------prob6-------")
    println(prob6(Seq("opton", "a", "hoge")))
    println(prob7(Seq(2, 101, 4, 2000)))
    println(prob7(Seq(2, 11, 4)))
    println(prob8(Seq(2, 11, 4)))
    println(prob9(Seq(2, 11, 4)))
    println(prob10(Seq(2, 11, 4)))
    println("-----prob11-----")
    println(prob11(Seq(1, 2, 3, 4, 5)))
    println("12: "+prob12(Seq(1, 2, 3, 4, 5)))
    //println("13: "+prob13(Seq.empty))
    println("14: "+prob14)
    println("15: "+prob15)

  }

  def prob1(numSeq: Seq[Int]) = {
    for{
      x <- numSeq
    } yield x match {
      case i if(i % 3 == 0) => 0
      case other => other
    }
  }

  def prob1Part2(numSeq: Seq[Int]) = {
    numSeq.map(x =>  if( x % 3 == 0) 0 else x)
  }

  def prob2(numSeq: Seq[Int]) = {
    numSeq.filter(_ % 3 == 0)
  }

  def prob3(numSeqSeq: Seq[Seq[Int]]) = {
    //val aSSeq = Seq(Seq(1,2,3), Seq(2), Seq(333))
    numSeqSeq.filter(_.exists(_ % 3 == 0))
  }

  def prob4(numSeq: Seq[Int]) = {
    numSeq.find(_ % 2 == 0) match {
      case Some(x) => x
      case None    => -1
    }
  }

  def prob4Part2(numSeq: Seq[Int]) = {
    numSeq.find(_ % 2 == 0).getOrElse(-1)
  }

  def prob5(numOptSeq: Seq[Option[Int]]) = {
    numOptSeq.find(_.contains(0)).flatten
  }

  def prob6(strSeq: Seq[String]) = {
    strSeq.collect{
      case x if(x.size >= 2) => x+"x"
    }
  }

  def prob7(numSeq: Seq[Int]) = {
    numSeq.filter( _ >= 100) match {
      case x if(x.nonEmpty) => x.collectFirst(_ * 2).getOrElse("")
      case _                => 0
    }
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

  def prob9(numSeq: Seq[Int]): Seq[Int] = {
    numSeq.init.tail
  }

  def prob10(numSeq: Seq[Int]): Int = {
    numSeq match {
      case x if(x.size >= 3)                => x.head + x.last
      case y if(y.size >= 1 && y.size <= 2) => 0
      case z if(z.isEmpty)                  => -1
    }
  }

  def prob11(numSeq: Seq[Int]) = {
    //numSeq.foldLeft(0)((acc, n ) => acc+n)
    numSeq.foldLeft(Seq.empty[Int])((acc, n) => n +: acc)
  }

  def prob12(numSeq: Seq[Int]) = {
    numSeq.foldLeft(0)((acc, n) => {
      acc + n
    })
  }

  def prob13(numSeq: Seq[Int]) = {
    if(numSeq.isEmpty) throw new RuntimeException("empty...")
    else numSeq.reduce((acc, n) => acc + n)
  }

  def prob14: Int = {
    Seq(3*4, 4*2, 4*1).min
  }

  def prob15: Int = {
    Seq(3*4, 4*2, 4*1).max
  }
}
