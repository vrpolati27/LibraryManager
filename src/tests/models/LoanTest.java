package models;

import org.junit.Test;
import utility.GenderType;
import utility.LoanStatus;
import utility.TitleType;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class LoanTest {
    Customer cust = new Customer(TitleType.Mr,"Vinay Reddy Polati",
            "San Francisco Bay Area","vrpolati@syr.edu",
            "7327627034",1, GenderType.MALE);
    Material sherlockHomes = new Dvd(1,"Sherlock Homes","br1",
            "Rajamauli","cat1378",93);

    Material algorithms = new Book("Advanced Algorithms","Vinay Reddy Polati",
            9,"9505323510136524","br1",403);

    @Test
    public void getDueDate() {
        Loan loan = new Loan(1,cust,sherlockHomes);
        /* tests if due date is set correctly for Dvd types.*/
        Calendar gcExpected = new GregorianCalendar();
        gcExpected.add(GregorianCalendar.DATE,sherlockHomes.getLoanPeriod());
        GregorianCalendar gcActual = new GregorianCalendar();
        gcActual.setTime(loan.getDueDate());
        assertEquals("wrong Year",gcExpected.get(GregorianCalendar.YEAR),
                gcActual.get(GregorianCalendar.YEAR));
        assertEquals("wrong Month", gcExpected.get(GregorianCalendar.MONTH),
                gcActual.get(GregorianCalendar.MONTH));
        assertEquals("wrong Date",gcExpected.get(GregorianCalendar.DATE),
                gcActual.get(GregorianCalendar.DATE));

        /* tests if due date is set correctly for Book types.*/
        loan = new Loan(2,cust,algorithms);
        gcExpected = new GregorianCalendar();
        gcExpected.add(GregorianCalendar.DATE,algorithms.getLoanPeriod());
        gcActual.setTime(loan.getDueDate());
        assertEquals("Difference in year",gcExpected.get(GregorianCalendar.YEAR),
                gcActual.get(GregorianCalendar.YEAR));
        assertEquals("Difference in month",gcExpected.get(GregorianCalendar.MONTH),
                gcActual.get(GregorianCalendar.MONTH));
        assertEquals("Difference in date",gcExpected.get(GregorianCalendar.DATE),
                gcActual.get(GregorianCalendar.DATE));
    }

    @Test
    public void getStatus(){
        /* checking Dvd status*/
        Loan loan = new Loan(1,cust,sherlockHomes);
        assertEquals("wrong status (before endLoan())",LoanStatus.CURRENT,loan.getStatus());
        loan.endLoan();
        assertEquals("wrong status (after endLoan())",LoanStatus.HISTORIC,loan.getStatus());

        /* checking book status*/
        loan = new Loan(2,cust,algorithms);
        assertEquals("wrong status (before endLoan())",LoanStatus.CURRENT,loan.getStatus());
        loan.endLoan();
        assertEquals("wrong status (after endLoan())",LoanStatus.HISTORIC,loan.getStatus());
    }

    @Test
    public void endLoan() {
       Loan loan = new Loan(2,cust,sherlockHomes);
       assertNull(loan.getReturnDate());
       loan.endLoan();
       assertNotNull(loan.getReturnDate());
       assertEquals("wrong status,(after endLoan)",LoanStatus.HISTORIC,
               loan.getStatus());

       GregorianCalendar gcalExpected = new GregorianCalendar();
       GregorianCalendar gcalActual = new GregorianCalendar();
       gcalActual.setTime(loan.getReturnDate());
       assertEquals("wrong year",gcalExpected.get(GregorianCalendar.YEAR),
               gcalActual.get(GregorianCalendar.YEAR));
       assertEquals("wrong month",gcalExpected.get(GregorianCalendar.MONTH),
               gcalActual.get(GregorianCalendar.MONTH));
       assertEquals("wrong date",gcalExpected.get(GregorianCalendar.DATE),
               gcalActual.get(GregorianCalendar.DATE));
    }

}