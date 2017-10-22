package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookCatalogTest {
    @Test
    public void addBook() throws Exception {
        BookCatalog bc = new BookCatalog();
        Book book = new Book("Learn Java","",1,"","",145);
        bc.addBook(book);
        assertEquals("difference in #books",1,bc.getBooksCount());
        bc.addBook(new Book("","",2,"","",1234));
        bc.addBook(new Book("","",2,"","",1234));
        assertEquals("difference in #books",2,bc.getBooksCount());
    }

    @Test(expected = BookNotFoundException.class)
    public void findBookByTitle() throws BookNotFoundException {
        BookCatalog bc = new BookCatalog();
        Book book = new Book("Learn Java","",1,"","",145);
        bc.addBook(book);
        try{
            bc.findBookByTitle("Learn Java");
        }catch(BookNotFoundException exception){
            fail("Error in findBookByTitle(), Learn java should not have thrown error");
        }
        bc.findBookByTitle("Learn More Java");
    }

}