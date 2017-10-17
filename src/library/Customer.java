package library;
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
            for(int i=1;i<names.length-1;i++){
                middleName.append(names[i]+" ");
            }
            this.middleName = middleName.toString();
        }else{
            this.middleName = new String();
        }
        this.isValid = true;
    }

    /* constructor2 */
    public Customer(TitleType title,String firstName, String middleName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /* returns FullName*/
    public String getFullName(){
        return firstName+" "+ middleName+" "+lastName;
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
        String mailingName = this.title+" "+firstName.charAt(0)+" "+lastName;
        return mailingName;
    }

    public GenderType getGender(){
        return gender;
    }
}
