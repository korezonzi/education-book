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