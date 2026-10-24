# Library Management System

A simple Java application for managing a library. It allows users to add, remove, and search for books by author or publication year through a command-line interface.

The project uses Maven and JUnit 5 for unit testing.

## Testing

JUnit tests are used to verify the functionality of the Library class.

## Question

**Is it easy to test the Main class? Why?**

No, because the Main class depends on user input from the console. To test it, we would need to simulate what the user types and check what the program displays. This makes it more difficult to test than the Library class, where we can call methods directly and compare their results with the expected values.