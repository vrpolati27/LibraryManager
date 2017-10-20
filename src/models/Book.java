package models;

public class Book extends Material {
    private String author;
    private String isbn;
    private int pagesCount;

    /* constructor1 */
    private Book(String title, String author, int id, String isbn,String branch){
        super(id,title,branch);
        this.author = author;
        this.isbn = isbn;
    }

    /* constructor2*/
    public Book(String title,String author,int id,String isbn,String branch,int pagesCount){
        this(title,author,id,isbn,branch);
        this.pagesCount = pagesCount;
    }

    /*This method returns the Author of the Book. */
    public String getAuthor(){
        return author;
    }


    /* returns ISBN code of the Book.*/
    public String getIsbn(){
        return isbn;
    }


    /* returns the #pages in a Book. */
    public int getPagesCount() {
        return pagesCount;
    }

    /* sends book for repair. */
    public void sendForRepair(){
        System.out.println(" Book has been sent for repair");
    }

    @Override
    public int getLoanPeriod() {
        return 21;
    }
}
