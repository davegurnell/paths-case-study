# Route Finding Case Study

A Scala / functional programming case study based on
[this kata](https://github.com/tyrcho/path-kata).

## Overview

Imagine some route finding API that provides
possible paths from a source to a destination.

Given a list of paths, select the best one
based on distance and whether it includes intermediate stops (points along the path).

Expect the API to produce **only valid path lists**
according to the following specification:

- A path list has:
   - a list of paths

- A path has:
   - a list of segments

- A segment has:
   - a source point
   - a destination point

- A point has:
   - an x coordinate
   - a y coordinate

## Suggested Steps

Try solving the kata in the following steps:

1. Write code to handle distance:
    1. Compute the distance of a segment
    2. Compute the distance of a path
    3. Find the shortest path in a list of paths
2. Write code to handle stops:
    1. Calculate the points along a path
    2. Filter paths keeping only those which include a point
    3. Filter paths keeping only those which include a given list of points
3. Write code to find the best path in a list of paths

Bonus problem (harder):

- Given a list of segments, compute all possible paths between 2 points.

## Tips

### Use Placeholders

Start every method by writing its signature and `???` as its body:

~~~scala
def myMethod(arg1: Arg1Type, arg2: Arg2Type): ResultType =
  ???
~~~

Remember:

- You can use `???` anywhere in your code
  to stub out something you don't yet know how to write.

- If you're having trouble with a big line of code:
   - split it into smaller lines;
   - assign each intermediate result to a variable;
   - put a type annotation on each variable.

### TDD

You might consider writing the code using TDD:

- Start by writing a unit test
- Allow the test to fail (to compile or to pass)
- Write just enough application code to make the unit test pass
- Write another test (and so on)

I have preconfigured a unit testing library called
[ScalaTest](http://www.scalatest.org/) to get you started.

## SBT Cheat Sheet

~~~bash
> compile                    # compile your code

> test                       # run all tests

> testOnly <CLASSNAME>       # run all tests in a single test suite

> testOnly paths.SegmentSpec # run all tests in SegmentSpec

> run                        # run your code (needs a main class/method)
~~~
