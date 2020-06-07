abstract class SayHello() {
  def printHello(): Unit = {
    println("hello")
  }
}

class B extends SayHello
class C extends SayHello
val b = new B()
b.printHello()

abstract class Person(
  name: String,
  age:  Int
) {
  def greet(): Unit
}

//Personを継承したJapaneseを定義
case class Japanese(
  name: String,
  age:  Int
) extends Person(name = name, age = age) {
  def greet(): Unit = {
    println("こんにちは")
  }
}

//Person継承; Indian
case class Indian(
  name: String,
  age:  Int
) extends Person(name = name, age = age) {
  def greet(): Unit = {
    println("namasute")
  }
}
val indiadn = Indian(
  "hoge",
  23
)
indiadn.name
indiadn.greet()

class C() extends SayHello {
  override def printHello(): Unit = {
    println("変更ずみHello")
  }
}
val c = new C()
c.printHello()

trait AA {
  final def printHello(): Unit = {
    println("Hello")
  }
}

//Final だよーってエラーになる
//class BB() extends AA {
//  override def printHello(): Unit = {
//    println("コンにtは")
//  }
//}

trait AAA {
  private val message = "Hello"
  def printHello(): Unit = {
    println(message)
  }
}
class BBB extends AAA
val bbb = new BBB
//ないよーってエラーになる
//b.message

