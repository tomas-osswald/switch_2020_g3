package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidCCException;

public class CCnumber implements ValueObject {

    private String ccNumber;
    private final static String INVALIDCC = "CC is not valid";


    public CCnumber(String ccNumber) {
        this.ccNumber = ccNumber;
        validateData();
    }

    private void validateData() {
        if(!validateCC()){
            throw new InvalidCCException(INVALIDCC);
        }
    }

    private boolean validateCC() {
        return true;
    }


}
