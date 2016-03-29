# My set of notes about Scala

This repository is a compilation of notes to myself about Scala, if you want to make any comments  in it, please go ahead.

## Scala Type Hirarchy

First thing first, let the a look at Scala Type Hierarchy (look the picture)

1. One the top of the hirarchy you have any, that represent anything in scala.

2. Below of Any you have AnyVal and AnyRef the things that are associated with primitives are AnyVal.

3. Another type immediately below Any is AnyRef, here all class type from java, scala that you can import or create gona be here.

4. Bellow AnyVal you get Unit. This is the minnium ammount of information, for example, you can think Unit as equivalent of void in Java, but take care, in the functional programing the function should return something, otherwise it will not be a function at all.

5. Noting is type that is son of everything, it will be return to you when you get a expection, again, in a functional language make sense return something, even if something is Nothing LOL!

![Alt text](https://raw.githubusercontent.com/LuizClaudioSantos/scala-notes/master/img/scala_type_hierarchy.png)

## Types

There are no primive types, all primitives are object, so you call methods from primitives.

```
  (4).toString()
  4.5.toString()
  "4.5".toDouble
```   

## Variables
 
1. Variables can be mutable *var b = 5* or inmutable *val b = 5* , immutable variables are preferred in Scala.
2. You can use this sintaxe *val c:Int =5* to be sure about the type of variable c.
3. The type inferred, so "a" in *val a = 5* is a Integer, even more, there is no primitive in Scala, so "a" is a reference to a Integer.
4. Tuples are a group of values that can be used to pass as a result of a function.  
 
```
 object Variables {
 
   val a = 5
   var b = 5
   val c:Int = 5
   val x, y, z = 10
   
   //Tuples
   val (c,d) = (5,"five")
   val (e, f, g) = (5, 5.5, "five")
   val (h, i, j) = (_, 5.5, "five")
 }
```   

## Conditional

1. The conditional "if" is Scala is a expression, it means, the if returns a value.
2. Try to figure out, what gonna be the type of less? It will be Unit, as I said above it is  type that means almost anything.
3. And what gonna be the type of "c" on *val c = if(a < 9) 4* ? It gonna be AnyVal, because the expression is equivalent to *val c = if(a < 9) 4 else ()*, () is Unit, the Scala give back a type that can be appled for both 4 and Unit, 4 and Unit are Any, hence the type of the conditional in this case is Val.
4. In the same way, the value of d is Any, because 4 and "not less", Int and String, are Any.  

```
object Conditional {

  val a = 5

  val b = 10

  val bigger = if(a > b) a else b
  
  val less = if(a < 7) println("less")
  
  val c = if(a < 9) 4
  
  val d = if(a < 9) 4 else "not less"

}
```
The match is the Scala equivalent to the switch in Java, note that insteat default, it use "_", there other places where we can use "_", it means something in the most of the cases.
```
 val result1 = a match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "Something else"
  }
```

We can use expressions in match case.
```
  val result2 = a*3 match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "Something else " + a*3
  }
```
Here "i" assumes the value of the match expression.
```
  val result3 = a match {
    case 0 => "zero"
    case 1 => "one"
    case i => "Something else " + i
 }
```
If you want to compare a pre defined variable "b" with the expression in the match, in this case a? The code below doesn't do that, because b is assuming the value of the "a".
```
  val result4 = a match {
    case 0 => "zero"
    case 1 => "one"
    case b => "It is b"
    case _ => "Something else"
  }
```
So you can user '' to confirm that you want to use the value of the predefined variable b.
```
  val result5 = a match {
    case 0 => "zero"
    case 1 => "one"
    case 'b' => "It is b"
    case _ => "Something else"
  }
```
You can use tuples in match as well, but the case must to be compatible with tuples.
```
val result6 = (2,3) match {
    case (1,2) => "zero"
    case (1,3) => "one"
    case i => "Something else " + i
  }
```

## Functions
1. *def* defines the new function.
2. *(value:Int)* recives the variable *value* of the type Int.
3. *(value:Int):Int* indicates that it return a Int.
4. The return value is the value of the last sentece in the function, in this case value*value.
5. You should use the "=" to tie function definition to its body, remenber you are not programming in Java.
6. The "{}" are optional on this case.
```
 def square(value:Int):Int = value * value
```

Recursion function example to calculate the value of a factorial

```
def factorial(number:Int):Int = if (number < 2 ) 1 else number * factorial(number -1)`
```

Now this function have to estimate Pi. The idea here is based on the ratio of points inside of circle against of the number of circle but inside of a square that contains the could bring a estimative about the PI. However this algorithm have a problem, recursive calls is not exclusive call of the function, but add other operations *(if(x*x+y*y < 1) 1 else 0) + helper(n-1)*m these operations gone be add to data in tVM stack and a stack overflow exception can be launched for big values of n.

```
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
``` 

1. So to prevent that, we need a tail recursion, it means that only call of function itself should be called.
2. You can use the annotaion @tailrec to be sure that you function is tail recursive.
3. Note that I can put the import in the middle of the code.

```
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
``` 

## Collections
1. You can declare an List as the code below.
2. The array is mutable, so the code *array1(0)=42* is valid.

```
  val array1 = Array(1,2,3)
  array1(0) = 42
```

1. You can declare a list like the code below.
2. The list is inmutable, so the code *list(0)=42* is invalid.
3. You can use the sintaxe *42::list* to add a value to the list, in really, it create a new list with the value.
```
val list = List(1,2,3)
list(0) = 42
42::list
```

1. You can determine the size and the type of the elements of Collection using a sintaxe like as *new Array[String](1000)*
2. Is possible also pass a function to generate values in the collections, to that we can use the method fill.
```
val array2 = new Array[String](1000)
val array3 = Array.fill(100)(math.random)
```  

But even without the fill method we can fill a collection. The function littleArray below will get its parameter passed by value,so that why array5 get three elements with the same value, however in the function littleArrayByName, the parameter to the function is passed by name, not by value, so a new value is generte for each element of the array 6.
```
def littleArray(i:Int):Array[Int] = Array(i,i,i)
val array5 = littleArray(util.Random.nextInt(10))

def littleArrayByNme(i: => Int):Array[Int] = Array(i,i,i)
val array6 = littleArrayByNme(util.Random.nextInt())
```

Another way to fill out the collection is using the lambda expression *i => i\*i*
```
val array7 = Array.tabulate(10)(i => i*i)
```

Adding a element to an array
```
2 +: array1
```

Concatenating two arrays
```
array1 ++: array2
```

Get a tuple form the elements
```
val (before, after) = array3.splitAt(4)
```


1. You can alse have a range in Scala.
2. The ranges *(1)to(10)* and *1 to 10* are equivalent.
3. In the ranges you can specify the number that will be used as incremental value.
```
val range1 = (1)to(10)
val range2 = 1 to 10
val range3 = 1 to 10 by 2
val range4 = 10 to 1 by -1
val range5 = 0.1 to 1.0 by 0.1
```  
