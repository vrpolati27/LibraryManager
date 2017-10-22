package models;

import utility.GenderType;
import utility.TitleType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/*********************************************
 * Developer Name: Vinay Reddy Polati        *
 * Email:          vrpolati@syr.edu          *
 *                                           *
* ********************************************/

public class Customer {

    private TitleType title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String emailId;
    private String address;
    private int customerNumber;
    private GenderType gender; /*{F:Female, M:Male, UK: UNKNOWN}*/
    private boolean isValid;
    private Date validThru;

    /* constructor1 */
    public Customer(TitleType title, String fullname,String address, String emailId, String phoneNumber,
                    int  customerNumber,GenderType gender){
        this.address = address; this.phoneNumber = phoneNumber; this.emailId = emailId;
        this.customerNumber = customerNumber; this.gender = gender;
        this.title = title;
        int spaceIndex = fullname.indexOf(" ");
        this.firstName = spaceIndex != -1? fullname.substring(0,spaceIndex): fullname;
        String[] names = fullname.split("\\s+");
        this.lastName = names.length>1 ? names[names.length-1]:new String();
        if(names.length>2){
            StringBuilder middleName = new StringBuilder();
            for(int i=1;i<names.length-2;i++){
                middleName.append(names[i]+" ");
            } middleName.append(names[names.length-2]);
            this.middleName = middleName.toString();
        }else{
            this.middleName = new String();
        }
        this.isValid = true;

        /* Set default exp date to be 1 Year from the start of creating account.*/
        Date today = new Date();
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(today);
        gcal.add(GregorianCalendar.YEAR,1);
        validThru = gcal.getTime();
    }

    /* constructor2 */
    public Customer(TitleType title,String firstName, String middleName, String lastName){
        this.title = title;
        this.firstName = firstName.trim();
        this.middleName = middleName.trim();
        this.lastName = lastName.trim();

        /* Set default exp date to be 1 Year from the start of creating account.*/
        Date today = new Date();
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(today);
        gcal.add(GregorianCalendar.YEAR,1);
        validThru = gcal.getTime();
    }

    /* returns FullName*/
    public String getFullName(){
        StringBuilder fullName = new StringBuilder(firstName);
        fullName.append(" ");
        fullName.append(middleName); fullName.append(" ");
        fullName.append(lastName);
        return fullName.toString();
    }

    /* returns FirstName*/
    public String getFirstName(){
        return firstName;
    }

    /* returns MiddleName */
    public String getLastName(){
        return this.lastName;
    }

    /* returns LastName */
    public String getMiddleName(){
        return  this.middleName;
    }

    /* returns Mailing Name,
 -----------------------------------------------------------------------------------
 | Mailing Name = Title + space + First Initial + space + Surname                   |
 -----------------------------------------------------------------------------------
   Eg: Mr. V Polati for [Vinay Reddy Polati]. */
    public String getMailingName(){
        StringBuilder mailingName = new StringBuilder(this.title+" ");
        mailingName.append(firstName.charAt(0)+" ");
        mailingName.append(lastName);
        return mailingName.toString();
    }

    public GenderType getGender(){
        return gender;
    }

    /* returns exp date. */
    public String getExpDate(){
        return validThru.toString();
    }

    /* returns expired date in a required Format*/
    public String getExpDate(SimpleDateFormat sdf){
        return sdf.format(validThru);
    }

    @Override
    public String toString() {
        return getMailingName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerNumber != customer.customerNumber) return false;
        if (isValid != customer.isValid) return false;
        if (title != customer.title) return false;
        if (!firstName.equals(customer.firstName)) return false;
        if (!middleName.equals(customer.middleName)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        if (!phoneNumber.equals(customer.phoneNumber)) return false;
        if (!emailId.equals(customer.emailId)) return false;
        if (!address.equals(customer.address)) return false;
        if (gender != customer.gender) return false;
        return validThru.equals(customer.validThru);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + emailId.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + customerNumber;
        result = 31 * result + gender.hashCode();
        result = 31 * result + (isValid ? 1 : 0);
        result = 31 * result + validThru.hashCode();
        return result;
    }
}
