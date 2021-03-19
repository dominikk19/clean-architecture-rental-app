package pl.dkiszka.rentalapplication.query.hotelroom.dto;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface HotelRoomReadModelDto {

    String getUuid();

    String getHotelId();

    int getNumber();

    List<SpaceReadModelDto> getSpaces();

    String getDescription();
}
