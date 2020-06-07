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


