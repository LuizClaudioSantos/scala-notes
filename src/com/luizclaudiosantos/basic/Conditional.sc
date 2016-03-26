object Conditional {
  val a = 5
  val b = 10
  val bigger = if(a > b) a else b
  val less = if(a < 7) println("less")
  val c = if(a < 9) 4
  val d = if(a < 9) 4 else "not less"
}