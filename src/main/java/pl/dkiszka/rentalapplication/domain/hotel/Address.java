package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class Address {
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String city;
    private String country;

    Address(String street, String postalCode, String buildingNumber, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.country = country;
    }
}
