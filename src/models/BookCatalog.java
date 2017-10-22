package models;

import ui.ConsoleInterface;

import java.util.HashMap;
import java.util.Map;

public class BookCatalog {
    private Map<Integer,Book> books;

    /*constructor1*/
    public BookCatalog(){
        books = new HashMap<>();
    }

    /* This method adds a book to current books catalog if there is a room
    * T(n)=O(1), constant time */
    public void addBook(Book book){
        books.put(book.getId(),book);
    }

    /* searches all the books and returns a book if found in the catalog,
    * T(n) = O(n) where 'n' is the #books */
    public Book findBookByTitle(String title) throws BookNotFoundException {
        for(Book book:books.values()){
            if(book != null && book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        throw new BookNotFoundException();
    }


    /* This method prints all the books information onto console.
    * T(n) = O(n), where 'n' is the #books in the catalog. */
    public void displayBooks(){
       ConsoleInterface.printBookHeader();
       ConsoleInterface.printLine();
       System.out.println();
       for(Book book:books.values()){
           ConsoleInterface.printBook(book);
       }
    }

    /* returns #books in the catalog*/
    public int getBooksCount(){
        return books.size();
    }

}
