object APIDefaultMethods {

  val array1 =  Array(1,2,3)
  val array2 =  Array.fill(10)(math.random)
  val array3 = Array.tabulate(10)(i => i*i)
  val list = List(7, 2, 4, 9)

  array1 ++: array2
  2 +: array1

  array1.head

  array1.tail

  array1.drop(2)

  array1.take(2)

  array1.reverse

  val (before, after) = array3.splitAt(4)

  array3.slice(3,9)

  val range1 = (1)to(10)
  val range2 = 1 to 10
  val range3 = 1 to 10 by 2
  val range4 = 10 to 1 by -1
  val range5 = 0.1 to 1.0 by 0.1

}