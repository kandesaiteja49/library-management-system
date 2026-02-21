<<<<<<< HEAD
# library-management-system
=======
# Library Management System — Java (OOP + SOLID + Design Patterns)

## Overview

This project implements a console-based Library Management System in Java.
It demonstrates Object-Oriented Programming (OOP), SOLID principles, and common design patterns.
The system manages books, patrons, lending, inventory, and a reservation queue.

This implementation focuses on clean architecture and extensibility rather than persistence or databases.

---

## Features

### Book Management

* Add, remove, and update books
* Search books by title, author, or ISBN
* Track availability status

### Patron Management

* Add and update patrons
* Track borrowing history

### Lending Process

* Checkout books
* Return books
* Automatic availability tracking

### Reservation Queue

* FIFO reservation queue per book
* If a book is unavailable, patrons are queued
* When returned, book is auto-issued to next patron
* Notification sent using Observer pattern

---

## OOP Concepts Used

* Encapsulation — private fields with controlled access
* Abstraction — interfaces for strategies and observers
* Polymorphism — interchangeable search strategies
* Composition — services composed of models
* Interfaces — behavior contracts

---

## SOLID Principles Applied

* **Single Responsibility** — each class has one job
* **Open/Closed** — new search strategies can be added without modifying existing code
* **Liskov Substitution** — all search strategies are interchangeable
* **Interface Segregation** — small focused interfaces
* **Dependency Inversion** — services depend on interfaces, not implementations

---

## Design Patterns Used

### Factory Pattern

Used to create Book objects via BookFactory.

### Strategy Pattern

Used for pluggable search behavior:

* TitleSearch
* AuthorSearch
* IsbnSearch

### Observer Pattern

Used for reservation notifications:

* Patron = Observer
* ReservationSubject = Subject

---

## Java Collections Used

* HashMap — book, patron, and loan storage
* List — borrowing history
* Queue (LinkedList) — reservation queue
* Stream API — searching and filtering

---

## Logging

Java Util Logging is used to log:

* Book additions
* Checkouts
* Returns
* Reservation events

---

## How to Run

Compile:

```
javac */*.java Main.java
```

Run:

```
java Main
```

---

## Possible Extensions (Not Implemented)

* Database persistence
* Multi-branch libraries
* Recommendation engine
* REST API layer
* Thread-safe concurrency handling

---

## Author Notes

This project is designed to demonstrate:

* Clean OOP design
* Pattern usage
* Extensible architecture
* Interview-ready coding practices

---

## class Diagram (UML)

See class diagram section below.

---

```
    Book
```

---

isbn : String
title : String
author : String
year : int
available : boolean
reservationQueue : Queue<Patron>
--------------------------------

update()
getters()
---------

---

```
   Patron
```

---

id : String
name : String
history : List<Book>
--------------------

addHistory()
update()  <-- Observer
----------------------

---

```
    Loan
```

---

book : Book
patron : Patron
issueDate : LocalDate
---------------------

---

## LibraryService

books : Map
patrons : Map
loans : Map
-----------

addBook()
checkout()
returnBook()
search()
--------

SearchStrategy (interface)
|
|--- TitleSearch
|--- AuthorSearch
|--- IsbnSearch

Observer (interface)
Subject (interface)

ReservationSubject implements Subject
Patron implements Observer

BookFactory
createBook()
>>>>>>> 6b29768 (Initial commit: Library Management System using OOP)
