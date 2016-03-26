# My set of notes about Scala

This repository is a compilation of notes to myself about Scala, if you want to make any comments  in it, please go ahead.



## Scala Type Hirarchy

First thing first, let the a look at Scala Type Hierarchy (look the picture)

1. One the top of the hirarchy you have any, that represent anything in scala.

2. Below of Any you have AnyVal and AnyRef the things that are associated with primitives areAnyVal

3. Another type immediately below Any is AnyRef, here all class type from java, scala that you can import or create gona be here.

4. Bellow AnyVal you get Unit. This is the minnium ammount of information, for example, you can think Unit as equivalent of void in Java.



![Alt text](scala_type_hirarchy.pmg)




## Basic

1. Primitves are objects, so you call methods from primitives
```
  (4).toString()
  4.5.toString()
  "4.5".toDouble
``  
  