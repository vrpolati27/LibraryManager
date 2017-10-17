import library.*;

public class Driver {

    public static void main(String[] args){
        customerClassDemo(); /* library.Customer */
        bookClassDemo(); /*  library.Book */

    }

    /* This method tests working of library.Customer class*/
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
    }

    /* This method tests working of library.Book class*/
    private static void bookClassDemo(){
        System.out.println();
        Book java = new Book("Introduction to Java","Vinay Reddy",1,"12345");
        Book swift = new Book("Swift programming","Tim cook",2,"23456");
        ConsoleInterface.printBookHeader();
        ConsoleInterface.printLine();
        System.out.println();
        ConsoleInterface.printBook(java);
        ConsoleInterface.printBook(swift);
    }

}
