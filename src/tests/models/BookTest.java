package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book book = new Book("Java HeadFirst","Jim Fawcett",1013,
            "9781306813204","br1",309);

    @Test
    public void getAuthor() throws Exception {
        assertEquals("Jim Fawcett", book.getAuthor());
    }

    @Test
    public void getIsbn() throws Exception {
        assertEquals("9781306813204",book.getIsbn());
    }

    @Test
    public void getPagesCount() throws Exception {
        assertEquals(309,book.getPagesCount());
    }

    @Test
    public void getLoanPeriod() throws Exception {
        assertEquals(21,book.getLoanPeriod());
    }

}