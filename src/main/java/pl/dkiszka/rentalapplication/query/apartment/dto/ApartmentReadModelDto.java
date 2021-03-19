package pl.dkiszka.rentalapplication.query.apartment.dto;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface ApartmentReadModelDto {
    String getUuid();

    String getOwnerId();

    String getStreet();

    String getPostalCode();

    String getHouseNumber();

    String getApartmentNumber();

    String getCity();

    String getCountry();


    String getDescription();

    List<RoomReadModelDto> getRooms();
}
