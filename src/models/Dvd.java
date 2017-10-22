package models;

public class Dvd extends Material {
    private String director;
    private String catalogNumber;
    private int runningTime; /* in minutes.*/
    private boolean isLicenced = true;

    /* constructor1 */
    public Dvd(int id, String title, String branch, String director, String catalogNumber, int runningTime) {
        super(id, title, branch);
        this.director = director;
        this.catalogNumber = catalogNumber;
        this.runningTime = runningTime;
    }

    /* returns the name of the director*/
    public String getDirector() {
        return director;
    }

    /* returns the catalog number*/
    public String getCatalogNumber() {
        return catalogNumber;
    }

    /* returns the running time of the movie in minutes.*/
    public int getRunningTime() {
        return runningTime;
    }

    /* returns the running time of the movie in Hours*/
    public float getTimeInHours(){
        float runTime;
        runTime = runningTime/60.0f;
        return  runTime;
    }

    /* returns true if the DVD is licenced, false if it is not licenced. */
    public boolean isLicenced(){
        return isLicenced;
    }

    /* sets the licence.*/
    public void setLicenced(boolean licenced) {
        isLicenced = licenced;
    }


    @Override /* lend only if book is licenced.*/
    public boolean lend(Customer customerId) {
        if(isLicenced){
            return super.lend(customerId);
        }else{
            return false;
        }
    }

    @Override /* loan period for Dvd's is 14*/
    public int getLoanPeriod() {
        return 14;
    }
}
