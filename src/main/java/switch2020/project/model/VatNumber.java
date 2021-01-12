package switch2020.project.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class VatNumber {
    private int vatNumber;

    /********************** CONSTRUCTORS **********************/

    public VatNumber(Integer vatNumber){
        if(!validateVatNumber(vatNumber))
            throw new IllegalArgumentException("Inserir o numero de valores do vatNumber correctamente.");
        this.vatNumber = vatNumber;
    }

    /********************** GETTERS AND SETTERS **********************/


    public boolean validateVatNumber(Integer vatNumber){
        String regex = "\\d{9}";
        String vat = String.valueOf(vatNumber);
        boolean test = Pattern.matches(regex,vat);
        if (vatNumber == null ) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VatNumber)) return false;
        VatNumber vatNumber1 = (VatNumber) o;
        return vatNumber == vatNumber1.vatNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }
}
