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
  }

  val optNumSome = Some(Some(2))
  val optNumNone = Some(None)

  def optionQuestion1(num: Option[Int]): Int = {
    num.getOrElse(0)
  }

  def optQ2(num: Option[Int]): Option[Int] = {
    num match {
      case Some(x) => Some(x).map(x => x+3)
      case None    => None
    }
  }

  def optQ3: Unit = {
    val strOpt: Option[String] = Some("")
    println(strOpt.isEmpty) //false
    println(strOpt.isDefined) //true
  }

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
}
