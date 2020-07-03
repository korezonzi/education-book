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

val result: Option[(String, String, String)] = Some("aa", "vv", "uu")
result.map(x => x)
result.map(x => (x._1, x._2, x._3))
//例題の説明
//org : Organizationが使用されていない & 3つを返すために.map
//そのままだと、faの値が返されるため

val res = for {

}