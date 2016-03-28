object Collections {
  val array1 = Array(1,2,3)
  array1(0) = 42
  val list = List(1,2,3)
  42::list

  val array2 = new Array[String](1000)
  val array3 = Array.fill(100)(math.random)

  def littleArray(i:Int):Array[Int] = Array(i,i,i)
  val array4 = littleArray(5)
  val array5 = littleArray(util.Random.nextInt(10))

  def littleArrayByNme(i: => Int):Array[Int] = Array(i,i,i)
  val array6 = littleArrayByNme(util.Random.nextInt())

  val array7 = Array.tabulate(10)(i => i*i)


}