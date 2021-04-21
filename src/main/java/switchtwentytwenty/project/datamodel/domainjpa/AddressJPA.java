package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Getter;
import switchtwentytwenty.project.domain.valueobject.City;
import switchtwentytwenty.project.domain.valueobject.DoorNumber;
import switchtwentytwenty.project.domain.valueobject.Street;
import switchtwentytwenty.project.domain.valueobject.ZipCode;

import javax.persistence.Entity;

@Entity
public class AddressJPA {

    @Getter
    private Street street;
    @Getter
    private City city;
    @Getter
    private ZipCode zipCode;
    @Getter
    private DoorNumber number;

    public AddressJPA(Street street, City city, ZipCode zipCode, DoorNumber number) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.number = number;
    }
}
