package switch2020.project.model;

import java.util.regex.Pattern;

public class VatNumber {
    private int vatNumber;

    /********************** CONSTRUCTORS **********************/

    public VatNumber(int vatNumber){
        if(!validateNull(vatNumber))
            throw new IllegalArgumentException("Inserir vatNumber.");
        if(!validateFormat(vatNumber))
            throw new IllegalArgumentException("Inserir o numero de valores do vatNumber correctamente.");
        this.vatNumber = vatNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validateNull(int vatNumber){
        if (vatNumber == 0 ) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validateFormat(int vatNumber){
        String regex = "\\d{9}"; //"\\d{9}(-\\d{1})?";
        String vat = String.valueOf(vatNumber);
        boolean test = Pattern.matches(regex,vat);
        if (test) {
            return true;
        } else {
            return false;
        }
    }

    //AND(ISPICKVAL( Account.Country_Codec ,"Portugal"),NOT(REGEX( Account.Zip_Postal_Codec , "^\d{4}-\d{3}$")))

    public int getVatNumber(){
        return this.vatNumber;
    }

}
