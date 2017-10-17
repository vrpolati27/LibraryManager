package library;

/*
 Description: This class defines methods to output objects to console in a specified Format

 Book's header and Each book information should be as Follows.
 ------------------------------------------------------------------------
|    BookID   Title                   Author              // Book header|
|    ------   --------------------    --------------------              |
|    12345    An Introduction to J    Matt Greencroft      // Book info |
|    23456    Better java             Joe Le Blanc                      |
|                                                                       |
| (6 chars)   (20 characters)         (20 characters)                   |
|------------------------------------------------------------------------
  */
public class ConsoleInterface {

    /* This method prints a dashed line onto console.*/
    public static void printLine(){
        for(int c1=0;c1<60;c1++){
            System.out.print("-");
        }
    }

    /* prints Book Header onto console as in above Format*/
    public static void printBookHeader(){
        System.out.println("BookId  Title                 Author");
    }

    /* prints Book information onto console as in above Format. */
    public static void printBook(Book book){
       // String bookIdString = String.valueOf(book.getId());
       System.out.println(fixedLengthString(book.getId(),6)+"  "+
                    fixLengthString(book.getTitle(),20)+"  "+
                        fixLengthString(book.getAuthor(),20));
    }

    /* This method takes a string and manipulates it to return a String of given Length
    by shrinking it or appending spaces to end of it. */
    private static String fixLengthString(String str,int length){
        if(str.length()>=length){
            /* shrink the text*/
            return str.substring(0,length);
        }else{
            /* append required spaces to the end of String.*/
            StringBuilder sb = new StringBuilder(str);
            while(sb.length()<length){
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    private static String fixedLengthString(int num,int length){
        String numString = String.valueOf(num);
        return fixLengthString(numString,length);
    }
}
