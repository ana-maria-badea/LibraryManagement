
package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search books by author");
            System.out.println("4. Search books by year");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Year: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    library.addBook(new Book(title, author, year));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Title to remove: ");
                    String removeTitle = scanner.nextLine();

                    System.out.print("Author: ");
                    String removeAuthor = scanner.nextLine();

                    System.out.print("Year: ");
                    int removeYear = Integer.parseInt(scanner.nextLine());

                    library.removeBook(
                            new Book(removeTitle, removeAuthor, removeYear)
                    );

                    System.out.println("Remove request completed.");
                    break;

                case 3:
                    System.out.print("Author: ");
                    String searchAuthor = scanner.nextLine();

                    List<Book> authorBooks =
                            library.getBooksByAuthor(searchAuthor);

                    printBooks(authorBooks);
                    break;

                case 4:
                    System.out.print("Year: ");
                    int searchYear = Integer.parseInt(scanner.nextLine());

                    List<Book> yearBooks =
                            library.getBooksByYear(searchYear);

                    printBooks(yearBooks);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println(
                        book.getTitle() + " - " +
                                book.getAuthor() + " (" +
                                book.getYear() + ")"
                );
            }
        }
    }
}
