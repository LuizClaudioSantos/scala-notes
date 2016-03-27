object Functions {

  def square(value : Int):Int = value * value
  square(2)
  def greet(name:String):Unit = println("Hello " + name)
  greet("Luiz")
  def factorial(number:Int):Int = if (number < 2 ) 1 else number * factorial(number -1)
  factorial(10)

  def estimatePi(n:Int):Double = {
    def helper(n:Int): Double = {
      if(n < 1 ) 0 else {
        val x = math.random
        val y = math.random
        (if(x*x+y*y < 1) 1 else 0) + helper(n-1)
      }
    }
    helper(n)/n*4
  }

  import scala.annotation._
  def estimatePiTailRecursion(n:Int):Double = {
    @tailrec
    def helper(n:Int, sum:Int): Double = {
      if(n < 1 ) sum else {
        val x = math.random
        val y = math.random
        helper(n-1, sum + (if(x*x+y*y < 1) 1 else 0))
      }
    }
    helper(n, 0)/n*4
  }

  estimatePiTailRecursion(1000000000)

}