package library;

public class Book {
    private String title;
    private String author;
    private int id;
    private String isbn;

    /* constructor1 */
    public Book(String title, String author, int id, String isbn){
        this.title = title;
        this.author = author;
        this.id = id;
        this.isbn = isbn;
    }

    /* This returns the title of the Book. */
    public String getTitle(){
        return title;
    }

    /*This method returns the Author of the Book. */
    public String getAuthor(){
        return author;
    }

    /* returns Id of the Book. */
    public int getId(){
        return id;
    }

    /* returns ISBN code of the Book.*/
    public String getIsbn(){
        return isbn;
    }
}
