object MapProblem {
  val fruits = Map("りんご" -> 100, "みかん" -> 80, "ぶどう" -> 300)
  def main(args: Array[String]): Unit = {
    println("1: "+ prob1 )
    println("2: "+ prob2 )
    println("3: "+ prob3 )
    println("4"+prob4)
    println("5:"+prob5)
  }

  //みかんの値を取得
  def prob1= {
    fruits.getOrElse("みかん", "not found")
  }

  def prob2 = {
    fruits.get("イチゴ") //None返す
    fruits.getOrElse("イチゴ", 0)
  }

  def prob3 = {
    println(fruits.get("ぶどう")) //Some(300)
    println(fruits.get("いちご")) //None
    println(fruits.getOrElse("ぶどう", "not found"))
    println(fruits.contains("ぶどう"))//true
    println(fruits.contains("ぶどうs"))//false
  }

  def prob4 = {
    fruits.mapValues(_ + "円").toMap
  }

  //TODO
  def prob5 = {
    val numbers = Seq(1,2,3,4,5).zipWithIndex.toMap
    /*numbers.groupBy(_ % 2 == 0)*/
  }
}