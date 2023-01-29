# Chapter 1 introduction

## Refactoring Overview

The first thing to refactoring is to create a well-covered suite of tests for the section of code
you want to refactor.

The essence: small change, then test after the change.

### Extract function

extract function and consider:

* Use as few parameters as possible, calculate some parameters from other parameters
* Rename the parameters for the extracted function to have better meaning


### Replace temp variable with query

If some temp parameters can be queries from a function, extract that query function and use it.
Remove temp variables is good for doing extractions later.

### Split loop

Split calculation of different variables into different loops, one loop will only calculate one variable,
this is good for future function extraction.

Don't be afraid to run multiple loops, the performance difference will be neglegible if they are only computations.

### Inline Variable

Replace the temp variable with function call, to remove the variable completely.

### Rule of thumb

Alway make the code base cleaner when you finish one commit.

# Chapter 2 Principles of Refactoring

## Why should we refactor

1. Your code should not break during refactoring
2. When you add feature, you should not change existing code, when you refactor, you should not change or add feature.
3. One key goal is to remove code duplication and reduce code lines, which is good for future updates.
4. Another goal is to make the code easier to understand.
5. Refactor help us code faster.
6. Refactor help us find bugs easily.

# Chapter 3 Bad Smells in Code

## Mysterious Name

## Duplicate Code

* Extract Method
* Pull method up the class hierarchy
  

## Long Function

Conditional and loops usually is a sign for extraction

* Extract Method
* Replace Temp with Query (to eliminate parameters)
* Introduce Parameter Object
* Replace Function with Command
* Replace switch with polymorphism (if there are more than one place switch on the same condition)
* Split loops

## Long Parameter List

* Replace parameter with query
* Preserve whole object (pass the whole object)
* Introduce parameter object
* Remove flag argument

## Global data

* Encapsulate variable

## Mutable data

## Divergent changes

## Shortgun Surgery

## Feature Envy

## Data Clumps

## Primitive Obsession

## Repeated Switches

## Loops

## Lazy Element

## Speculative Generality

## Temporary Field

## Middle Man

## Insider Trading

## Large Class

## Alternative class with different interfaces

## Data class

## Refused Bequest

## Comments

# Chapter 3 Building Tests