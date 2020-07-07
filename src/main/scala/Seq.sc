Seq(1,2,3).map(_ * 2)
Seq(Seq(1,2,3), Seq(4,5,6)).flatten

Seq(1,2).flatMap(x => {
  Seq(3,4).map(y => {
    (x,y)
  })
})

Seq(Seq(1,2,3), Seq(4,5), Seq(7)).flatMap(x => x)
Seq(Seq(1,2,3), Seq(), Seq(5,7)).flatMap((x => x))
Seq(Seq(1,2,3), Seq(), Seq(5,6)).flatMap(x => 10 +: x)
Seq(Seq(1,2,3), Seq(), Seq(5,6)).flatMap(10 +: _) //上と同じ
Seq(Seq(1,2,3), Seq(), Seq(5,6)).flatMap(_ :+ 10)
Seq(Seq(1,2,3), Seq(4,5)).map(_.size)
Seq(Seq("hello", "world"), Seq("hhhh", "hoge")).flatten.map(_.toUpperCase())
Seq(Seq("hello", "world"), Seq("hhhh", "hoge")).flatMap(_.map(_.toUpperCase()))

for{
  a <- Seq(1,2)
  b <- Seq(3,4)
}yield (a,b)

val numSeq: Seq[Int]  = Seq(1,2,3)
//find: 値見つけると終了
//Some(x), None返す
numSeq.find(_ % 2 == 1)
numSeq.reverse.find(_ % 2  == 1)
numSeq.find(_ > 8)

numSeq.filter(_ > 1)
//該当なし: 空のSeq返す
numSeq.filter(_ > 11)

numSeq.collect{
  case x if(x % 2 == 0) => "even"
  case y if(y % 2 == 1) => "odd"
}

//findとmapの融合
//Some(odd)になる
numSeq.collectFirst{
  case x if(x % 2 == 0) => "even"
  case y if(y % 2 == 1) => "odd"
}
//Option[Int]にしてもOptionで包まれる訳では無い
Some(5).collectFirst(_ * 2)

//exists: ある条件があるか
//contains: 要素があるか
numSeq.exists(_ %  2 == 1 )
numSeq.contains(1)
numSeq.contains(4)
//empty: 値が入ってても空のSeqとか作れる
numSeq.empty
val hoge: String = "hgoe"
hoge.empty
numSeq.head
numSeq.last
numSeq.init
numSeq.tail
Seq(1).tail  //List()

numSeq.headOption
numSeq.lastOption
numSeq.empty.lastOption

//TODO: 理解必要
val seq3 = Seq(1,2,3)
seq3 match {
  case h +: _  +: _ :+ l => h + l
  case _ +: _  => 0
  case Nil => -1
}
numSeq :+ 2
2 +: numSeq
numSeq ++ numSeq
Nil
Seq.empty
numSeq ++ Nil

val xs = List(1,2,3,4,5)
var sum = 0
for(x <- xs) {
  sum = sum + x
  //sum += x
}
sum

xs.foldLeft(0){(sum, x) =>
  sum + x
}
sum
def reverse(numSeq: Seq[Int]) = {
  numSeq.foldLeft(Seq.empty[Any]){(acc, x) =>
    x +: acc
  }
}


xs.foldLeft(0: Int){(acc: Int, n: Int) =>
  println(acc)
  println(n)
  println( acc - n)
  acc - n
}
xs.foldLeft(0)((z, n) => z - n)

xs.foldRight(0)((acc, n) => acc +n)
xs.foldRight(0)((acc, n) => acc - n)
xs.reduce((acc, n) => acc+n)
xs.min
xs.max
Seq.empty match {
  case Nil => 0
}