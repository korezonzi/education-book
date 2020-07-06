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

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。Seq[Int]型である、numSeqが引数として渡されるseqQuestion1メソッドがあります。numSeqの要素のうち、3の倍数の要素のみ0に変換する関数を実装してください。
  def prob1(numSeq: Seq[Int]) = {
    for{
      x <- numSeq
    } yield x match {
      case i if(i % 3 == 0) => 0
      case other => other
    }
  }

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion2メソッドがあります。 numSeqのうち3の倍数のみを返すメソッドをfilterを使って作成してください。Seq[Int]型である、numSeqが引数として渡されるseqQuestion2メソッドがあります。 numSeqのうち3の倍数のみを返すメソッドをfilterを使って作成してください。
  def prob1Part2(numSeq: Seq[Int]) = {
    numSeq.map(x =>  if( x % 3 == 0) 0 else x)
  }

  def prob2(numSeq: Seq[Int]) = {
    numSeq.filter(_ % 3 == 0)
  }

  //Seq[Seq[Int]]型である、numSeqSeqが引数として渡されるseqQuestion3メソッドがあります。 numSeqSeqのうち3の倍数を含むSeqのみを返すメソッドをfilterとexistsを使って作成してください。
  def prob3(numSeqSeq: Seq[Seq[Int]]) = {
    //val aSSeq = Seq(Seq(1,2,3), Seq(2), Seq(333))
    numSeqSeq.filter(_.exists(_ % 3 == 0))
  }

  //Seq[Int]型である、numSeqが引数として渡されるseqQuestion4メソッドがあります。 numSeqに偶数が含まれていればその最初の値を、含まれていない場合は-1を返すメソッドをfindを使って作成してください。Seq[Int]型である、numSeqが引数として渡されるseqQuestion4メソッドがあります。 numSeqに偶数が含まれていればその最初の値を、含まれていない場合は-1を返すメソッドをfindを使って作成してください。
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

  //Seq[String]型である、strSeqが引数として渡されるseqQuestion6メソッドがあります。 strSeqのうち文字列の長さが2以上であるものの末尾に"x”を追加し、それらのみを含むSeqを返すメソッドを、collectを使って作成してください。Seq[String]型である、strSeqが引数として渡されるseqQuestion6メソッドがあります。 strSeqのうち文字列の長さが2以上であるものの末尾に"x”を追加し、それらのみを含むSeqを返すメソッドを、collectを使って作成してください。
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

  /*問題1 文字列の配列、strSeqが与えられます。※ seqの定義は以下
  val strSeq: Seq[String] = Seq("し", "な", "て", "も", "お")
  foldLeftを使って、"おもてなし"(型はString)という文字列を作成してください。(他に必要なメソッドがあれば、使用しても構わない)*/
  /*問題2: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
  reduce もしくは reduceOptionを使って、intSeqの中身を合計する処理を作成してください。(配列が空の場合には、0を返すこと)*/

  /*問題3: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
  collectを使って、1の場合には"x"を、2の場合には"y"を、それ以外の場合には"z"に変換し配列を返す処理を作成してください。*/

  /*ちょっと発展
  問題4: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1*1, 2*2, 4*4, 3*3) もしくは Seq()
  reduceOptionを使って、intSeqの最大値を算出する処理を作成してください。(配列が空の場合は、0を返すこと)問題1 文字列の配列、strSeqが与えられます。※ seqの定義は以下
  val strSeq: Seq[String] = Seq("し", "な", "て", "も", "お")
  foldLeftを使って、"おもてなし"(型はString)という文字列を作成してください。(他に必要なメソッドがあれば、使用しても構わない)*/

  /*問題2: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
  reduce もしくは reduceOptionを使って、intSeqの中身を合計する処理を作成してください。(配列が空の場合には、0を返すこと)*/

  /*問題3: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1,2,3,4) もしくは Seq()
  collectを使って、1の場合には"x"を、2の場合には"y"を、それ以外の場合には"z"に変換し配列を返す処理を作成してください。*/

  /*ちょっと発展
  問題4: 数字の配列、intSeqが与えられます。 ※ intSeqは空の可能性もある
  val intSeq: Seq[Int] = Seq(1*1, 2*2, 4*4, 3*3) もしくは Seq()
  reduceOptionを使って、intSeqの最大値を算出する処理を作成してください。(配列が空の場合は、0を返すこと)*/
}
