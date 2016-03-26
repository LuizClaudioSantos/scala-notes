object Conditional {
  val a = 5
  val b = 10
  val bigger = if(a > b) a else b
  val less = if(a < 7) println("less")
  val c = if(a < 9) 4
  val d = if(a < 9) 4 else "not less"
  val result1 = a match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "Something else"
  }

  val result2 = a*3 match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "Something else " + a*3
  }

  val result3 = a*3 match {
    case 0 => "zero"
    case 1 => "one"
    case i => "Something else " + i
  }

  val result4 = a match {
    case 0 => "zero"
    case 1 => "one"
    case b => "It is b"
    case _ => "Something else"
  }

  val result5 = a match {
    case 0 => "zero"
    case 1 => "one"
    case 'b' => "It is b"
    case _ => "Something else"
  }

  val result6 = (2,3) match {
    case (1,2) => "zero"
    case (1,3) => "one"
    case i => "Something else " + i
  }

}