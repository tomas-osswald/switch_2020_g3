package switch2020.project.model;

public class VatNumber {
    private Integer vatNumber;

    public VatNumber(Integer vatNumber){
        if(!validate(vatNumber))
            throw new IllegalArgumentException("Inserir valor.");
        this.vatNumber = vatNumber;
    }

    private boolean validate(Integer vatNumber){
        if (vatNumber == null )
            return false;
        return true;
    }

}
