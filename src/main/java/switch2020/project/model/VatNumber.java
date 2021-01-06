package main.java.switch2020.project.model;

public class VatNumber {
    private int vatNumber;

    /********************** CONSTRUCTORS **********************/

    public VatNumber(int vatNumber){
        if(!validate(vatNumber))
            throw new IllegalArgumentException("Inserir valor.");
        this.vatNumber = vatNumber;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validate(int vatNumber){
        if (vatNumber == 0 )
            return false;
        return true;
    }

    public int getVatNumber(){
        return this.vatNumber;
    }

}
