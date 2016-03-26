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