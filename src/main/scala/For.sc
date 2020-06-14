for(i <- 1 to 5) {
  println(i)
}
val opt1 = Some(1)
val opt2 = Some(2)
val opt3 = Some(3)
for{
  x <- opt1
  y <- opt2
  z <- opt3
} yield {
  x * y * z
}
