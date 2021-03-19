package pl.dkiszka.rentalapplication.query.hotel.dto;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface HotelReadModelDto {
    String getUuid();

    String getStreet();


    String getPostalCode();

    String getBuildingNumber();

    String getCity();

    String getCountry();
}
