package models;

import ui.ConsoleInterface;

public class BookCatalog {
    private Book[] books = new Book[10];
    private int nextFreeSpace = 0;

    /* This method adds a book to current books catalog if there is a room
    * T(n)=O(1), constant time */
    public boolean addBook(Book book){
        boolean addedSuccessfully = nextFreeSpace<books.length ? true:false;
        if(addedSuccessfully){
            books[nextFreeSpace++] = book;
        }
        return addedSuccessfully;
    }

    /* searches all the books and returns a book if found in the catalog,
    * T(n) = O(n) where 'n' is the #books */
    public Book findBookByTitle(String title){
        Book result = null;
        for(Book book:books){
            if(book != null && book.getTitle().equals(title)){
                result = book;
                break;
            }
        }
        return result;
    }


    /* This method prints all the books information onto console.
    * T(n) = O(n), where 'n' is the #books in the catalog. */
    public void displayBooks(){
       ConsoleInterface.printBookHeader();
       ConsoleInterface.printLine();
       System.out.println();
       for(int count=0;count<nextFreeSpace;count++){
           Book currentBook = books[count];
           ConsoleInterface.printBook(currentBook);
       }
    }

}
