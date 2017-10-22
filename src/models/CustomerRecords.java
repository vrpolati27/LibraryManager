package models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CustomerRecords {
    private Set<Customer> customers;

    /*constructor1 */
    public CustomerRecords(){
      customers = new HashSet<>();
    }

    /* adds customer to customersRecords*/
     public void addCustomer(Customer cust){
        customers.add(cust);
     }

    /* returns customer with given name.
    * T(n) = O(n), where 'n' is #customers in customerRecords. */
    public Customer getCustomer(String name) throws CustomerNotFoundException{
        Customer cust = null;
        Iterator<Customer> iterator = customers.iterator();
        while(iterator.hasNext()){
            Customer customer = iterator.next();
            if(customer.getFullName().equalsIgnoreCase(name.trim())){
                cust = customer;
                break;
            }
        }
        if(cust != null)return cust;
        else throw new CustomerNotFoundException();
    }

    /* returns #customers in customerRecords*/
    public int getCustomersCount(){
        return customers.size();
    }

}
