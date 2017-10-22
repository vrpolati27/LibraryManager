package models;

import utility.LoanStatus;

import java.util.Date;
import java.util.GregorianCalendar;

public class Loan {
    private int id;
    private Customer customer;
    private Material material;
    private Date startDate;
    private Date dueDate;
    private Date returnDate;
    private LoanStatus status;

    /* constructor1 */
    public Loan(int id, Customer customer, Material material) {
        this.id = id;
        this.customer = customer;
        this.material = material;

        /* set current date as start date*/
        this.startDate = new Date();

        /* set due date to be 2 weeks from start date if material is Book,
         3 weeks from start if material is Dvd.*/
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(startDate);
        gcal.add(GregorianCalendar.DATE,material.getLoanPeriod());
        this.dueDate = gcal.getTime();

        this.status = LoanStatus.CURRENT;
    }

    @Override
    public String toString() {
        StringBuilder loan = new StringBuilder("Loan[ id:");
        loan.append(id); loan.append(", customer:");
        loan.append(customer.getMailingName()); loan.append(", book:");
        loan.append(material.getTitle()); loan.append("]");
        return loan.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Loan loan = (Loan) object;
        return id == loan.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    /* returns customer who borrowed it.*/
    public Customer getCustomer() {
        return customer;
    }

    /* returns the Material */
    public Material getMaterial() {
        return material;
    }

    /* returns the date when the book is due.*/
    public Date getDueDate() {
        return dueDate;
    }

    /* returns status of the book.
    eg: if its already been given to any customer or not*/
    public LoanStatus getStatus() {
        return status;
    }

    /* sets the return date to today's date and status of book to HISTORIC*/
    public void endLoan(){
        this.status = LoanStatus.HISTORIC;
        this.returnDate = new Date();
    }


    /* returns return date of the Material. */
    public Date getReturnDate() {
        return returnDate;
    }

    /* returns start date of the Material. */
    public Date getStartDate() {
        return startDate;
    }

    public int getId() {
        return id;
    }
}
