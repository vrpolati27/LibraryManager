import library.Customer;

public class Driver {

    public static void main(String[] args){
        customerClassDemo(); /* library.Customer */
        
    }

    /* This method tests working of library.Customer class*/
    private static void customerClassDemo(){
        Customer vinayManager = new Customer("Mr","Vinay Reddy Polati");
        System.out.println("Fullname:"+vinayManager.getFullName());
        System.out.println("First name:"+vinayManager.getFirstName());
        System.out.println("Middle name:"+vinayManager.getMiddleName());
        System.out.println("Last name:"+vinayManager.getLastName());
        System.out.println("Mailing name:"+vinayManager.getMailingName());
    }

}
