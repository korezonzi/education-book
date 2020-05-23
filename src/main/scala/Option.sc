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




