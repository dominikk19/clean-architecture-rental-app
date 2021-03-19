package pl.dkiszka.rentalapplication.domain.hotel;

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
    private final String buildingNumber;
    private final String city;
    private final String country;
}
