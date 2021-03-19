package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Embeddable
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Address {
    private final String street;
    private final String postalCode;
    private final String houseNumber;
    private final String apartmentNumber;
    private final String city;
    private final String country;
}
