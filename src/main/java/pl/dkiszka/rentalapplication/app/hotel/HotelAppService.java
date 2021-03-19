package pl.dkiszka.rentalapplication.app.hotel;

import pl.dkiszka.rentalapplication.domain.hotel.HotelFactory;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public class HotelAppService {
    public void add(String name, String street, String postalCode, String buildingNumber, String city, String country) {
        new HotelFactory().create(name, street, postalCode, buildingNumber, city, country);
    }
}
