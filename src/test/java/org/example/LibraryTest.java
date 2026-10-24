
package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell", 1949);

        library.addBook(book);

        assertEquals(1, library.getBooksByAuthor("George Orwell").size());
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Life of Pi", "Yann Martel", 2001);

        library.addBook(book);
        library.removeBook(book);

        assertTrue(library.getBooksByAuthor("Yann Martel").isEmpty());
    }

    @Test
    public void testGetBooksByAuthor() {
        Library library = new Library();

        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Animal Farm", "George Orwell", 1945));
        library.addBook(new Book("Life of Pi", "Yann Martel", 2001));
        library.addBook(new Book("The Alchemist", "Paulo Coelho", 1988));

        List<Book> books = library.getBooksByAuthor("George Orwell");

        assertEquals(2, books.size());
        assertEquals("1984", books.get(0).getTitle());
        assertEquals("Animal Farm", books.get(1).getTitle());
    }

    @Test
    public void testGetBooksByYear() {
        Library library = new Library();

        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("The Second Sex", "Simone de Beauvoir", 1949));
        library.addBook(new Book("Life of Pi", "Yann Martel", 2001));
        library.addBook(new Book("The Alchemist", "Paulo Coelho", 1988));

        List<Book> books = library.getBooksByYear(1949);

        assertEquals(2, books.size());
        assertEquals("1984", books.get(0).getTitle());
        assertEquals("The Second Sex", books.get(1).getTitle());
    }

    @Test
    public void testRemoveNonExistingBook() {
        Library library = new Library();
        Book book = new Book("The Alchemist", "Paulo Coelho", 1988);

        library.removeBook(book);

        assertTrue(library.getBooksByAuthor("Paulo Coelho").isEmpty());
    }
}
