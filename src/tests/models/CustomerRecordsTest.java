package models;

import org.junit.Test;
import utility.GenderType;
import utility.TitleType;

import static org.junit.Assert.*;

public class CustomerRecordsTest {
    CustomerRecords customers;

    /* constructor1  */
    public CustomerRecordsTest(){
        customers = new CustomerRecords();
        Customer cust1 = new Customer(TitleType.Mr,"Ram Reddy Polati",
                "Fremont Blvd","vrpolati@syr.edu","7327627034",
                1, GenderType.MALE);
        customers.addCustomer(cust1);
        System.out.println("Full name:"+cust1.getFullName());
    }
    @Test
    public void addCustomer(){
       assertEquals(1,customers.getCustomersCount());
       Customer cust2 = new Customer(TitleType.Dr,"m1 m2 m3","Heaven complex",
               "email@gmail.com","9876543210",2,GenderType.UNKNOWN);
       customers.addCustomer(cust2);
       assertEquals(2,customers.getCustomersCount());
    }

    @Test(expected = CustomerNotFoundException.class)
    public void getCustomer() throws CustomerNotFoundException {
       try{
           Customer cust = customers.getCustomer("Ram Reddy Polati");
           System.out.println(cust);
       }catch(CustomerNotFoundException exception){
           fail("Error in CustomerRecords.getCustomer(String name)");
       }
       Customer unknown = customers.getCustomer("Vinay Reddy Polati");
       System.out.println(unknown);
    }

}