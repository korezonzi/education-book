//Accepted
//Memory Usage: 42.3 MB Runtime: 240 ms

object optionProblem {
  def main(args: Array[String]): Unit = {
    println(optionQuestion1(Some(2)))
    println(optQ2(Some(3)))
    println(optQ3)
    println(optQ4(Some(Some(2))))
    println(optQ4(Some(None)))
    println(optQ4(None))
  }

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
      case Some(x) => x.map(y => y *2)
      case None    => None
    }
  }
}
