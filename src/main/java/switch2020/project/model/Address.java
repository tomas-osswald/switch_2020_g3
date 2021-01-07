package switch2020.project.model;

public class Address {
    private final String street;
    private final String postalCode;
    private final String local;
    private final String city;

    /********************** CONSTRUCTORS **********************/

    public Address(String street, String postalCode,String local, String city){
        if(!validateEmpty(street))
            throw new IllegalArgumentException("Inserir Rua");
        this.street = street;

        if(!validateEmpty(postalCode))
            throw new IllegalArgumentException("Inserir Codigo Postal");
        this.postalCode = postalCode;

        if(!validateEmpty(local))
            throw new IllegalArgumentException("Inserir Localidade");
        this.local = local;

        if(!validateEmpty(city))
            throw new IllegalArgumentException("Inserir Cidade");
        this.city = city;
    }

    /********************** GETTERS AND SETTERS **********************/

    private boolean validateEmpty(String x){
        if (x == null)
            return false;
        return true;
    }
}
