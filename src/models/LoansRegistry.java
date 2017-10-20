package models;

public class LoansRegistry {

    private Loan[] registry;
    private int nextFreePosition;

    /* constructor1 */
    public LoansRegistry() {
        registry = new Loan[20];
        nextFreePosition = 0;
    }

    /* adds loan to the Registry.
    * T(n) = O(n), where 'n' is the #Loan entries in the registry*/
    public void addLoan(Loan loan) throws LoanAlreadyExistsException{
       for(int c1=0;c1<nextFreePosition;c1++){
          if(registry[c1].equals(loan)){
              throw new LoanAlreadyExistsException();
          }
       }

       registry[nextFreePosition] = loan;
       nextFreePosition++;
    }

    /* finds a Loan and returns it
    * T(n)=O(n), where 'n' = #loans in the registry. */
    public Loan findLoan(int materialId) throws LoanNotFoundException{
        for(int m1=0;m1<nextFreePosition;m1++){
            Loan loan = registry[m1];
            if(loan.getMaterial().getId() == materialId){
                return loan;
            }
        }
        throw new LoanNotFoundException();
    }


    /* returns true if book is already on loan and
      False otherwise.*/
    public boolean isBookOnLoan(int materialId){
        try{
            findLoan(materialId);
            return true;
        }catch(LoanNotFoundException exception){
            return false;
        }
    }

}
