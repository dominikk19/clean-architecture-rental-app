package pl.dkiszka.rentalapplication.domain.hotel;

import pl.dkiszka.rentalapplication.adapters.rest.api.hotel.HotelDto;

import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class HotelFactory {

    public static Hotel create(HotelDto hotelDto) {
        Address address = new Address(hotelDto.getStreet(), hotelDto.getPostalCode(), hotelDto.getBuildingNumber(),
                hotelDto.getCity(), hotelDto.getCountry());
        return new Hotel(UUID.randomUUID().toString(), hotelDto.getName(), address);
    }
}
