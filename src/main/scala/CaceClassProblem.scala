object CaceClassProblem {
  def main(args: Array[String]): Unit = {
    println(companyTuple)
    println(tupleTel)
    println(Company)
    println(company)
    println(companyKana)
  }

  val companyTuple = ("nextbeat", "03-5423-6131", Some("東京都恵比寿"))
  val tupleTel = companyTuple._2

  case class Company(
    name:     String,
    tel:      String,
    address: Option[String]
  )

  val company: Company = Company(
    "nextbeat",
    "03-5423-6666",
    Some("hoge")
  )

  val companyKana = company.copy(name = "ネクストビート")
}
