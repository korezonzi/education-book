val fruits: Map[String, Int] = Map("りんご" -> 100, "ぶどう" -> 300, "なし" -> 500)
fruits("りんご")
fruits + ("ばなな" -> 40)
//Map + Map
fruits ++ Map("かき" -> 200, "すいか" -> 900)

fruits - "すいか"
fruits - "あっき"

fruits.get("ぶどう")
fruits.get("ぶどうo")
fruits.getOrElse("りんご", "empty...")
fruits.getOrElse("りんffご", "empty...")
fruits.contains("りんご")
fruits.isDefinedAt("りんご")
fruits.keys
fruits.values
val nameMap:Map[Int, String] =Map (1 -> "佐藤", 2 -> "田中", 3 -> "高橋")
nameMap
//nameMap.mapValues(_ + "です")
//nameMap.filterKeys(_ % 2 == 0)
val userTupleSeq = Seq((1, "鈴木"), (2, "田中"), (3, "高橋"))
userTupleSeq.toMap
userTupleSeq.groupBy(_._1)

val numbers = Seq(1,2,3,4,5).zipWithIndex.toMap
//numbers.map(_._1 % 2 == 0)
numbers.map({
  x => if(x._1 % 2 == 0) Map(1 -> x)
  else Map(0 -> x)
})

val nn = Seq(1,2,3,4,5)
val resMap = nn.map(x => x match {
  case even if(x % 2 == 0) => Map(1 -> x)
  case y => Map(0 -> y)
})

val evenSeq = nn.filter(_ % 2  == 0)
val addSeq = nn.filter(_ % 2 != 0)
val resMaps = Seq(1,2,3,4,5).groupBy(_ % 2 ==0)

case class Article(
    id: Long,   // ID
    title: String,   // タイトル
    body: String   // 本文
)

val articles = Seq(
    Article(301, "出産祝いでおめでとうを伝えるとき。メールやカードでの伝え方", "友だちの場合やビジネスの場合の文例"),
    Article(122, "2歳の子どもが激しい人見知りをするとき。固まる理由や対応について", "習い事のときや男性に人見知りをするときの様子"),
    Article(530, "1歳の幼児食。野菜を食べてほしいときの献立例やレシピとは", "冷凍ストックやレトルトを使って時短に")
)

val articleMap = articles.groupBy(_.id)

articleMap.get(530)