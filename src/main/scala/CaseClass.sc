case class Person(
  name: String,
  age:  Int
)
val people = Seq(Person("tom", 1), Person("sam", 2))
people.map(_.name)


//val tom = Person("tom", 1)
//val tomName = tom.name
//val sam = Person(name = "sam", 1)

abstract class Shape(val height: Int){
  def calculate(): Int
}
class Rectangle(_height: Int) extends Shape (
  _height
){
  def calculate(): Int = {
    height * height
  }
}

//タプル
val d2: (Int, Int) = (10, 20)
val d3: (Int, Int, Int)= (1,2,3)

//営業時間


import java.time.LocalTime
val openHours: (LocalTime, LocalTime) = (LocalTime.of(10,0), LocalTime.of(21, 0))
val openTime  = openHours._1
val closeTime = openHours._2

val persons = ("taro", "suzuki")
persons._1

val tanaka = "Tanaka" -> 10 //(Tanaka, 10)になる

//case Class
case class Person(
  name: String,
  age : Int
)

val person = Person("田中", 21)
person.name

//class Animal(
//  val name: String,
//  val size: String,
//)
//val animal: Animal = new Animal("cat", "Small")

//case class
case class Animal(
  name: String,
  size: String
)
val animal = Animal("cat", "small")
Person.unapply(person)

val person1 = Person("Tanaka", 20)
val person2 = person1.copy(name = "sato")
person2
person1
person1.equals(person2)

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

val rectangular = new Rectangular(2,2,3)
val foursidedPyramid = new FoursidedPyramid(2,3)

abstract class Shape (val height: Int) {
    def calculate(): Int
  }

  case class Rectangular (_height: Int, width: Int, depth: Int) extends Shape (
    height = _height
  ) {
    def calculate(): Int = {
      height * width * depth
    }
  }

  val rectangular = Rectangular(10, 20, 10).calculate
