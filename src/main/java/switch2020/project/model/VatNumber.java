package main.java.switch2020.project.model;

public class VatNumber {
    private Integer vatNumber;

    /********************** CONSTRUCTORS **********************/

    public VatNumber(Integer vatNumber){
        if(!validate(vatNumber))
            throw new IllegalArgumentException("Inserir valor.");
        this.vatNumber = vatNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validate(Integer vatNumber){
        if (vatNumber == null )
            return false;
        return true;
    }

    public Integer getVatNumber(){
        return this.vatNumber;
    }

}
