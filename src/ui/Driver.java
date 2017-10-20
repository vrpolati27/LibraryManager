package ui;

import models.*;
import utility.GenderType;
import utility.TitleType;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static void main(String[] args){
        customerClassDemo(); /* models.Customer */
        bookClassDemo(); /*  models.Book */
        booksCatalogClassDemo(); /* models.BookCatalog */
        dataTimeDemo();
        handlingNumbers();/* java.text.NumberFormat */
        dvdDemo(); /*models.Dvd*/

    }

    /* This method tests working of models.Customer class*/
    private static void customerClassDemo(){
        Customer vinay = new Customer(TitleType.Mr,"Vinay Reddy Polati","39869 Fremont Blvd",
                "vrpolati@syr.edu","",13, GenderType.MALE);
        System.out.println("Fullname:"+vinay.getFullName());
        System.out.println("First name:"+vinay.getFirstName());
        System.out.println("Middle name:"+vinay.getMiddleName());
        System.out.println("Last name:"+vinay.getLastName());
        System.out.println("Mailing name:"+vinay.getMailingName());
        System.out.println("gender: "+vinay.getGender());
        if(vinay.getGender() == GenderType.MALE){
            System.out.println("He is Male");
        }else{
            System.out.println("He is Female");
        }
        System.out.println("valid through: "+vinay.getExpDate(
                new SimpleDateFormat("dd-MMM-yyyy")));
    }

    /* This method tests working of models.Book class*/
    private static void bookClassDemo(){
        System.out.println();
        Book java = new Book("Introduction to Java","Vinay Reddy",1,"12345","br1",312);
        Book swift = new Book("Swift programming","Tim cook",2,"23456","br2",129);
        ConsoleInterface.printBookHeader();
        ConsoleInterface.printLine();
        System.out.println();
        ConsoleInterface.printBook(java);
        ConsoleInterface.printBook(swift);
        System.out.println();
        swift.sendForRepair();
    }

    /* This method tests working of models.BookCatalog class*/
    private static void booksCatalogClassDemo(){
        BookCatalog books = new BookCatalog();
        Book java = new Book("Introduction to Java","Vinay Reddy",1,"12345",
                        "br1",654);
        Book swift = new Book("Swift programming","Tim cook",2,"23456",
                        "br2",876);
        Book algorithms = new Book("AlgorithmsForInterviews","AmitPrakash",3,"34567",
                        "br3",324);
        books.addBook(java);
        books.addBook(swift); books.addBook(algorithms);
        System.out.println();
        books.displayBooks();
        try{
            Book foundBook = books.findBookByTitle("AlgorithmsForInterviews");
            System.out.println("Found book, its ID:"+foundBook.getId()+" and ISBN:"+
                    foundBook.getIsbn());
        }catch(BookNotFoundException exception){
            System.out.println("Book not Found");
            exception.printStackTrace();
        }
        /*throw new RuntimeException("something went wrong");*/
    }

    /* This demonstrates using  Java in-built Data and Time Libraries.
     java.util.Date;
     java.util.GregorianCalender
     java.text.SimpleDateFormat*/
    private static void dataTimeDemo(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        System.out.println(" today is "+sdf.format(today));

        GregorianCalendar gcal = new GregorianCalendar(1994,1,27);
        gcal.add(GregorianCalendar.YEAR, 23);
        today = gcal.getTime();
        System.out.println(" today is "+sdf.format(today));

        GregorianCalendar birthDate = new GregorianCalendar(1994,1,27);
        GregorianCalendar _today = new GregorianCalendar();
        _today.setTime(today);
        long timeDifference = _today.getTime().getTime() - birthDate.getTime().getTime();
        System.out.println("Vinay Reddy Polati is:"+TimeUnit.DAYS.convert(
                        timeDifference, TimeUnit.MILLISECONDS)/365+" years old");
    }

    /* This method demonstrates how to handle Numbers in java
    * using java inbuilt libraries. */
    private static void handlingNumbers(){
        double d1 = 3.6789;
        NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance();
        System.out.println(numberFormat1.format(d1));
        Locale american = Locale.UK;
        numberFormat1 = NumberFormat.getCurrencyInstance(american);
        System.out.println(numberFormat1.format(d1));
        Locale indian = new Locale("hin","IN");
        //Locale chinese = Locale.CHINESE;
        numberFormat1 = NumberFormat.getCurrencyInstance(indian);
        System.out.println(numberFormat1.format(d1));

        d1 = 1.234;
        NumberFormat numberFormat2 = NumberFormat.getPercentInstance();
        numberFormat2.setMinimumFractionDigits(2);
        System.out.println(numberFormat2.format(d1));
        d1 = 1.4577899713;
        numberFormat2.setMaximumFractionDigits(3);
        System.out.println(numberFormat2.format(d1));

        d1 = 1.0;
        for(int m1=0;m1<5;m1++){
            d1 += 0.1;
            System.out.println(d1);
        }
         d1 = 1.0;
        numberFormat2 = NumberFormat.getNumberInstance();
        for(int m2=0;m2<5;m2++){
            d1 += 0.1;
            System.out.println(numberFormat2.format(d1));
        }

        BigDecimal price = new BigDecimal("2.0");
        BigDecimal newValue = new BigDecimal("0.1");
        for(int m3=0;m3<10;m3++){
            price = price.add(newValue);
            System.out.println(price);
        }

        price = new BigDecimal(9.0);
        for(int c1=0;c1<10;c1++){
            price = price.add(newValue);
            System.out.println(price);
        }
    }


    /* This method tests working of models.Dvd class*/
    private static void dvdDemo(){
        Dvd interstellar = new Dvd(9987,"Interstellar","br3",
                "Spielberg","13",123);
        Dvd interstellar2 = new Dvd(9987,"Interstellar","br3",
                "Spielberg","13",123);

        System.out.println(interstellar.getDirector());
        System.out.println(interstellar.isLicenced());

        System.out.println(interstellar);
        System.out.println(interstellar.equals(interstellar2));

    }



}
