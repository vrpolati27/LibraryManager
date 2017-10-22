package models;

import org.junit.Test;
import utility.GenderType;
import utility.TitleType;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer = new Customer(TitleType.Mr,"Vinay Reddy Polati","San Francisco BayArea",
            "vrpolati@syr.edu","7327627034",13, GenderType.MALE);

    @Test
    public void getFirstName() throws Exception {
        assertEquals("Vinay",customer.getFirstName());
    }

    @Test
    public void getMailingName() throws Exception {
        assertEquals("Mr V Polati",customer.getMailingName());
    }

    @Test
    public void getExpDate() throws Exception {
        //System.getProperty()
    }

    @Test
    public void getExpDate1() throws Exception {
    }

}