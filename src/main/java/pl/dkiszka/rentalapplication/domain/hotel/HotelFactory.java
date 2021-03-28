package pl.dkiszka.rentalapplication.domain.hotel;

import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public class HotelFactory {
    public static Hotel create(String name, String street, String postalCode, String buildingNumber, String city, String country) {
        Address address = new Address(street, postalCode, buildingNumber, city, country);
        return new Hotel(UUID.randomUUID().toString(), name, address);
    }
}
