The programming paradigm where everything is represented as an object is known as a truly object-oriented programming language.

The main aim of object-oriented programming is to implement real-world entities, for example, object, classes, abstraction, inheritance, polymorphism, etc.

## Object:
Any entity that has state and behavior is known as an object. For example, a chair, pen, table, keyboard, bike, etc. It can be physical or logical.

An Object can be defined as an instance of a class. An object contains an address and takes up some space in memory. Objects can communicate without knowing the details of each other's data or code. The only necessary thing is the type of message accepted and the type of response returned by the objects.

Example: A dog is an object because it has states like color, name, breed, etc. as well as behaviors like wagging the tail, barking, eating, etc.

## Class:
a blueprint from which you can create an individual object. Class doesn't consume any space.

# Pillers of OOPs
## 1.Inheritance:
When one object acquires all the properties and behaviors of a parent object, it is known as inheritance. It provides code reusability. It is used to achieve runtime polymorphism.
Inheritance allows one class to inherit properties and behaviors from another, creating a hierarchical relationship. This promotes code reuse and can help avoid 
redundancy by letting subclasses extend the functionality of parent classes. For instance, 
a Dog class can inherit common behaviors from a Animal class, while adding dog-specific features.

## 2.Polymorphism:
If one task is performed in different ways, it is known as polymorphism. For example: to convince the customer differently, to draw something, for example, shape, triangle, rectangle, etc.

Polymorphism allows objects to be treated as instances of their parent class, even though they may have different behaviors. 
This can manifest through method overriding (runtime polymorphism), where a subclass provides its specific implementation of a method, or method overloading (compile-time polymorphism), 
where methods with the same name differ in parameters.

## 3.Abstraction:
Hiding internal details and showing functionality is known as abstraction. For example phone call, we don't know the internal processing.

Abstraction simplifies complex systems by hiding unnecessary details and exposing only the essential features. 
This is typically done through abstract classes or interfaces. For example, a car's start() method 
may be abstracted so the user doesn't need to understand how the engine works to use the car.

## 4.Encapsulation:
Binding (or wrapping) code and data together into a single unit are known as encapsulation. For example, a capsule, it is wrapped with different medicines.

Encapsulation involves grouping data (attributes) and methods (functions) that operate on the data into a single unit, i.e., a class. 
This allows for better control over how the data is accessed or modified, 
protecting object integrity by restricting direct access through access modifiers. 
Developers can use getters and setters to interact with private variables safely.

in this module follow these files in order
intro1 - intro2 -> constructor - inheritance {inheritance} -> overloading(compile-time) - overriding(run-time) {polymorphism}
->Abstraction - interface {Abstraction} ->encapsulation {encapsulation}