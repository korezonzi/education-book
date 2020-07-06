object optionProblem {
  def main(args: Array[String]): Unit = {
    println(optionQuestion1(Some(2)))
    println(optQ2(Some(3)))
    println(optQ3)
    println(optQ4(optNumSome))
    println(optQ4(optNumNone))
    println(optQ4(None))
    println(opt04_2(optNumSome))
    println(opt04_2(optNumNone))
    println(opt04_2(None))
    println(opt04_3(optNumSome))
    println(opt04_3(optNumNone))
    println(opt04_3(None))
  }

  val optNumSome = Some(Some(2))
  val optNumNone = Some(None)

  //Option[Int]型である、numが引数として渡されるメソッドoptionQuestion1があります。Someの場合はその値を、Noneの場合は０を返却するメソッドを、getOrElseメソッドを使って作成してください。
  def optionQuestion1(num: Option[Int]): Int = {
    num.getOrElse(0)
  }

  /*Option[Int]型である、numが引数として渡されるoptionQuestion2メソッドがあります。
  Someの場合はその値に3を足したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを、mapメソッドを使って作成してください。Option[Int]型である、numが引数として渡されるoptionQuestion2メソッドがあります。Someの場合はその値に3を足したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを、mapメソッドを使って作成してください。*/
  def optQ2(num: Option[Int]): Option[Int] = {
    num match {
      case Some(x) => Some(x).map(x => x+3)
      case None    => None
    }
  }

  //val strOpt: Option[String] = Some("") を定義し、それに対してisEmpty, isDefined を実行した場合にどのような挙動をするか確かめてください。val strOpt: Option[String] = Some("") を定義し、それに対してisEmpty, isDefined を実行した場合にどのような挙動をするか確かめてください。
  def optQ3: Unit = {
    val strOpt: Option[String] = Some("")
    println(strOpt.isEmpty) //false
    println(strOpt.isDefined) //true
  }

  //Option[Option[Int]]型である、numが引数として渡されるoptionQuestion4メソッドがあります。Someの場合はその値を2倍したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを作成してください。Option[Option[Int]]型である、numが引数として渡されるoptionQuestion4メソッドがあります。Someの場合はその値を2倍したSome[Int]を、Noneの場合はそのままNoneを返却するメソッドを作成してください。
  def optQ4(num: Option[Option[Int]]): Option[Int] = {
    num match {
      case Some(x) => x.map(_ * 2)
      case None    => None
    }
  }
  //Some(None): case None に入る

  def opt04_2(num: Option[Option[Int]])= {
    num.flatMap(_.map(_ * 2))
  }

  def opt04_3(num: Option[Option[Int]]) = {
    num.flatten.map(_ * 2)
  }
  //Some(None): flattenでNoneになる

  //yield: 要素加工して、Optionで包んで返す
  def opt04_4(num: Option[Option[Int]]) = {
    for {
      optInt <- num
      int    <- optInt
    }yield int * 2
  }

}
