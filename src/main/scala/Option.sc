//TODO: FlatMap

val optNum  = Some(1)
val seqNum  = Seq(1,2,3)
val emp     = None
optNum.map(x => x.toString + "hoge")
optNum.map(_.toString+"hoges")
println("-----")
seqNum.nonEmpty
optNum.isEmpty
emp.isDefined
optNum.isDefined

val optitonNum: Option[Option[Int]] = Some(Some(3))
optitonNum.flatten
emp.flatten
val optNone: Option[Option[Int]] = Some(None)
optitonNum.flatten

Some(3).map(_ * 2)
val intVal: Option[Int] = Some(3)
intVal.flatMap(x =>
  if(x > 2)  {
    Some(x * 2)
  }
  else {
    None
  }
)
optNone.flatten
optitonNum.flatMap(x => x.map(_*2))
optitonNum.flatMap(_.map(_ * 2))

val result: Option[(String, String, String)] = Some("aa", "vv", "uu")
result.map(x => x)
result.map(x => (x._1, x._2, x._3))
//例題の説明
//org : Organizationが使用されていない & 3つを返すために.map
//そのままだと、faの値が返されるため

val optnumSome: Option[Option[Int]] = Some(Some(2))
val optNumNone: Option[Option[Int]] = Some(None)
optnumSome.flatMap { x =>
  x.map(_ * 2)
}

optnumSome.flatMap(_.map(_ * 2 ))
optNumNone.flatMap(_.map(_ * 2))

optNumNone match {
  case Some(x) => x
  case None    => None
}
optNumNone.flatten

for{
  optInt <- optNumNone
  x = println(s"optInt: ${optInt}") //Some(2)
  int    <- optInt
  y = println(s"int: ${int}")      //2
} yield int * 2                    //Some(4)
//yield: 要素を加工してOptionに包んで返してる