# BIT504_A2_TristanWilkinson
Java Library Management Assessment
Library Management Console Application
Assessment – Java Programming

This project is a console-based Library Management System written in java. it demonstrates core programming concepts including classes, objects, collections, file input/output, user input handling, easy and user friendly navigation. The application is lightweight and easy to use, Focusing on functionality and allow things to be kept simple for the user.

Features

Display all books and members
Add new books and members
Check books out and in
Search for books and members
Age-restricted borrowing rules
Clean, user-friendly menu system
Windows-safe screen clearing
Fully commented code for readability and assessment requirements

Project Structure

|   .gitignore
|   README.md
|   
|   
\---src
    +---documentation
    +---main
    |   +---java
    |   |   \---library
    |   |       |   Main.java
    |   |       |   
    |   |       +---managers
    |   |       |       LibraryManager.java
    |   |       |       MenuManager.java
    |   |       |       
    |   |       +---models
    |   |       |       Book.java
    |   |       |       Member.java
    |   |       |       
    |   |       \---utils
    |   |               FileReaderUtil.java
    |   |               
    |   \---resources
    |           books.txt
    |           members.txt
    |           
Data Files
The application loads book and member data from text files located in:

Code
src/main/resources/
books.txt – initial book records
members.txt – initial member records
These can be edited to add or remove data as needed.

Running the Application
Compile Code:
javac library/Main.java
Run Code:
java library.Main
Alternatively, the project can be run directly through an IDE such as VS Code or IntelliJ.

Author
Tristan Wilkinson 
Open Polytechnic of New Zealand
October 2026

Purpose
This project was created to meet the requirements of the Java programming assessment. It demonstrates:

Understanding of Java fundamentals
Ability to structure a multi-class application
Use of collections and file input
Implementation of a menu-driven console interface
Clear commenting and documentation practices
The goal was to build a functional, easy-to-read application rather than a complex system
