package models;

abstract public class Material {
     private int id;
     private String title;
     private String branch;
     private Customer borrower;


     /* constructor1 */
     public Material(int id, String title,String branch){
         this.id = id;
         this.title = title;
         this.branch = branch;
     }

    /* returns Id of the Material kind {Book, Dvd,...}. */
    public int getId(){
        return id;
    }

    /* This returns the title of the Material. */
    public String getTitle(){
        return title;
    }

    /* returns the location where the Material is stored.*/
    public String getBranch() {
        return branch;
    }

    /* changes the location of material to new branch.*/
    public void relocate(String newBranch){
        this.branch = newBranch;
    }


    /* returns true if it is nor borrowed and can lend and
    * returns false otherwise. */
    public boolean lend(Customer customer){
        if(borrower == null){
            borrower = customer;
            return true;
        }else{
            return false;
        }
    }

    /* must be overriden*/
    public abstract int getLoanPeriod();
}
