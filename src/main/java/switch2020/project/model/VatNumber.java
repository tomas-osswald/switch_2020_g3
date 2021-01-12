package switch2020.project.model;

import java.util.regex.Pattern;

public class VatNumber {
    private int vatNumber;

    /********************** CONSTRUCTORS **********************/

    public VatNumber(int vatNumber){
        if(!validateVatNumber(vatNumber))
            throw new IllegalArgumentException("Inserir o numero de valores do vatNumber correctamente.");
        this.vatNumber = vatNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    public boolean validateVatNumber(int vatNumber){
        String regex = "\\d{9}";
        String vat = String.valueOf(vatNumber);
        boolean test = Pattern.matches(regex,vat);
        if (vatNumber == 0 ) {
            return false;
        } else if (!test){
            return false;
        } else {
            return true;
        }
    }

    public int getVatNumber(){
        return this.vatNumber;
    }

}
