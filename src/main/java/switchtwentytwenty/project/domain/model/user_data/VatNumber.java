package switchtwentytwenty.project.domain.model.user_data;

import java.util.Objects;
import java.util.regex.Pattern;

public class VatNumber {
    private final int vat;

    /********************** CONSTRUCTORS **********************/

    public VatNumber(Integer vat){
        if(!validateVatNumber(vat))
            throw new IllegalArgumentException("Inserir o numero de valores do vatNumber correctamente.");
        this.vat = vat;
    }

    /********************** GETTERS AND SETTERS **********************/


    public boolean validateVatNumber(Integer vatNumber){
        String regex = "\\d{9}";
        String vat = String.valueOf(vatNumber);
        boolean test = Pattern.matches(regex,vat);
        if (vatNumber == null ) {
            return false;
        } else return test;
    }

    public int getVat(){
        return this.vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VatNumber)) return false;
        VatNumber vatNumber1 = (VatNumber) o;
        return vat == vatNumber1.vat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vat);
    }
}
