object HOMethods {
  val array = Array(1 ,2 ,3 ,4 ,5)
  val list = List(5, 2, 7, 1, 9, 3, 10)
  val vector = Vector.tabulate(10)(i => i*i)

  array.foreach(println)
  array.foreach(i => println(i))

  array.map(i => i*2)
  array.filter(_< 5)

  array.flatMap(i => array.take(i))

  vector.exists(_> 50)
  vector.forall(_<50)

  array.reduceLeft((x,y) => x+y)
  array.foldLeft(0)(_+_)
  array.foldLeft("0")(_+_)


}