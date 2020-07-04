//Q1
//Option[Int]型の numOptを引数として受け取り
//numOptがSomeでかつ値が10以上であれば、"A"
//numOptがSomeでかつ値が9以下、5以上であれば、"B"
//numOptがSomeでかつ値が4以下であれば"C"
//numOptがNoneであれば"D"
//を標準出力させるメソッドquestion1を作成してください

def question1(numOpt: Option[Int]) = {
  numOpt match {
    case Some(x) if(x >= 10)           => "A"
    case Some(y) if(y >= 5 && y <= 9 ) => "B"
    case Some(z) if(z <= 4)            => "C"
    case None                          => "D"
  }
}
println(question1(Some(8)))

//Q2
//Option[Int] => String に変換する関数 convと、Option[Int]型である numOpt を引数にとり、numOptを文字列にして返すメソッドconvertToStringがあります。convertToStringを使ってnumOpt: Option[Int]をStringに変換するメソッドquestion2を作成してください。
//numOptは以下の条件に従って変換させること
//     1.numOptがSome()であれば、そのIntの値をStringに変換する
//     2.numOptがNoneであれば、"空でした"というStringに変換する
//
//def convertToString(numOpt: Option[Int])(conv: Option[Int] => String): String = conv(numOpt)
//def question2(numOpt: Option[Int]): String = {
//  numOpt match {
//    case Some(x) => convertToString(numOpt).toString()
//    case None    => convertToString(None).toString()
//  }
//}
def question2(numOpt: Option[Int]) = {
  numOpt.map(_.toString).getOrElse("空でした")
}
println(question2(Some(3)))

//Q3
//Seq[Int]型であるnumsを引数として受け取り、配列の中身を昇順でソートするquesion3を作成してください
def question3(nums: Seq[Int]) = {
  nums.sorted
}

//×Q4
//Seq[Int]型であるnumsを引数として受け取り、配列の中身を降順でソートするquesion4を作成してください。その際にreverseメソッドは使用しないこと
def question4(nums: Seq[Int]) = {
  nums.sortWith((num, numNext) => num > numNext)
}

//Q5
//Seq[Option[Int]]型である、numOpsを引数にとりnumOpsの要素がSomeの場合は中の数字を、Noneの場合はリストから外したSeq[Int]を返すquestion5を作成してください
val numsOpt = Seq(Some(3), Some(5), None)
numsOpt.flatten
for{
  Some(x) <- numsOpt
}yield x

//6
val nums = Seq(2,5,1,5)
nums.zipWithIndex

//7
nums.zipWithIndex.max
nums.indexOf(nums.max)

//8
nums.distinct

//9
//case class Article(
//  id:
//)