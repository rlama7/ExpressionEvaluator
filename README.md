# CSC 413 - The Expression Evaluator - Project Summary

```
The goal of expression evaluator project is to design and program to evaluate a given infix
expression in Java language.

In an infix expression, an operator is written between the operands. The expression evaluator performs an arithmetic operation of given values of the operands: A, B, C and D and operators (+, -, \*, /, and ^) including left parenthesis "(" and right parenthesis ")".

For example: A + ((B \* C) - D /A)

```

## Development Environment

```
1. IntelliJ IDEA version 2018.2.4 (Ultimate version)
2. Java JDK-10.0.2 version
3. Gradle-4.10.1
4. Git version 2.14.2 on Windows Operating System (OS) 10
```

## Implementation

```
The objective of the expression evaluator project was to be able to implement three fundamental principles of Object-Oriented Programming (OOP) namely:

1. Encapsulation
• It refers to an OOP concept that binds together the data and functions that manipulate the data, and that keeps both safe from outside interference and misuse. A class can enforce the desired level of restriction to both the data and functions using access modifier such as private, public or protected keywords.

• Implementation: In the expression evaluator class I made sure that the attributes of the classes are properly encapsulated by using a private access modifier. Also, some of the methods such as our HashMap was made private.

2. Inheritance and Composition
• One class may share attributes with other classes either in an “is-a-type-of” relationships known as inheritance or “has-a” relationship known as composition. In such a scenario, we can create a parent/superclass, and the child class can inherit from the parent class.

For example, an elephant is an animal. A Bird is an animal. And so is a dolphin. So, we can create a super/parent class Animal class from which child class such as Elephant class, Bird class, and Dolphin class all inherit common attributes such as name, age, weight. However, each animal in our example has different outside protective layers. An elephant has a thick protective skin, a bird has feathers, and a dolphin has scales.

• Implementation: All the operator subclasses/child class such as AddOperator, SubtractOperator, MultiplyOperator, DivideOperator, PowerOperator, LeftParenthesis, and RightParenthesis inherit from the parent Operator class.

3. Polymorphism
• Polymorphism makes OOP programming dynamic in the sense that same operation name may behave differently on different classes.

For example, consider creating an animal class in JAVA. All animals move. But all movements are not the same.

An elephant has four legs to move.

A bird flaps its wings to fly and also has two legs to walk.

And dolphins have fins and tail which they move to help them propel in the water.

• Implementation: Operator class is a parent class and it has priority() and execute() methods as abstract. Each subclass that inherits from the parent class implements those methods, and each behaves differently depending on the subclass. For example: in AddOperator subclass, method execute() adds operand one and operand two with an operator whereas in the SubtractOperator subclass method execute() subtracts operand two from operand one
```

## Project Conclusion/Results

```
In this project I got to dive deeper into implementing principles of object-oriented programming (OOP) namely encapsulation, inheritance, and polymorphism to create two programs:
1. An evaluator class that evaluates infix arithmetic expression
2. A GUI around the artifact from (1)

OOP is a joy to work when one truly understands the fundamental principles namely:
i)Encapsulation,
ii) Inheritance, and
iii0 Polymorphism.

OOP method allows us to model the real-world scenario in our program. I struggled in following logical condition in the algorithm. Past two weeks I spent my days mid-day sweating, and my nights are burning the midnight oil. Nevertheless, this project was an essential milestone in my career as a software engineer. I am ready to move onto the next challenge. And happy to admit I am better prepared than before.
```
