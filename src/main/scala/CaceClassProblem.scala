//​// abstract class 問題
//abstract class Solid(height: Int) {
//  def calculate(): Int
//}
//​
//class RectangularSolid(height: Int, width: Int, length: Int) extends Solid (height) {
//  def calculate(): Int = width * length * height
//}
//​
//class Pyramid(height: Int, width: Int, length: Int) extends Solid (height) {
//  def calculate(): Int = width * length * height / 3
//}

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


  /*abstract class Parameter(
    val height: Int,
    val side:   Int
  ){
    def calculate(): Int
  }
​
  class Rectangular(
    height: Int,
    side:   Int,
    length: Int
  ) extends Parameter(height = height, side = side){
    def calculate(): Int = {
      (side * length +
       side * height +
       length * height
      ) * 2
    }
  }
​
  class FoursidedPyramid(
    height: Int,
    side:   Int
  ) extends Parameter(height = height, side = side){
     def calculate(): Int = {
       side * side + (side * height / 2 * 4)
     }
  }*/
  abstract case class Parameter(
    height: Int,
    width: Int
  ) {
    def calculate: Int
  }

  class Rectangular(
    height: Int,
    width: Int,
    length: Int
  ) extends Parameter(height = height, width = width) {
    def calculate: Int = {
      width * length * height
    }
  }

  class FoursidedPyramid(
    height: Int,
    width: Int,
  ) extends Parameter(height, width) {
    def calculate: Int = {
      width * width + (width * height / 2 * 4)
    }
  }
  /*val rectangularSolid = new RectangularSolid(5,3,4)
  val pyramid = new Pyramid(2, 9,9)*/
}
