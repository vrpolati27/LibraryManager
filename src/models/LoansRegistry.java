package models;

import java.util.HashMap;
import java.util.Map;

public class LoansRegistry {

    private Map<Integer,Loan> registry;

    /* constructor1 */
    public LoansRegistry() {
        registry = new HashMap<>();
    }

    /* adds loan to the Registry.
    * T(n) = O(1), constant time.*/
    public void addLoan(Loan loan) throws LoanAlreadyExistsException{
       Loan m1 = registry.getOrDefault(loan.getId(),null);
       if(m1==null){
           registry.put(loan.getId(),loan);
       }else{
           throw new LoanAlreadyExistsException();
       }
    }

    /* finds a Loan and returns it
    * T(n)=O(n), where 'n' = #loans in the registry. */
    public Loan findLoan(int materialId) throws LoanNotFoundException{
        for(Loan loan:registry.values()){
            if(loan.getMaterial().getId() == materialId){
                return loan;
            }
        }
        throw new LoanNotFoundException();
    }


    /* returns true if book is already on loan and
      False otherwise.*/
    public boolean isMaterialOnLoan(int materialId){
        try{
            findLoan(materialId);
            return true;
        }catch(LoanNotFoundException exception){
            return false;
        }
    }

}
