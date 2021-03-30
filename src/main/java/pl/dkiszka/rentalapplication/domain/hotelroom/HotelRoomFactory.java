package pl.dkiszka.rentalapplication.domain.hotelroom;

import pl.dkiszka.rentalapplication.adapters.rest.api.hotelroom.HotelRoomDto;

import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class HotelRoomFactory {

    public static HotelRoom create(HotelRoomDto hotelRoomDto) {
        var spaces = hotelRoomDto.getSpacesDefinition().entrySet().stream()
                .map(entry -> new Space(entry.getKey(), entry.getValue()))
                .collect(toList());
        return new HotelRoom(UUID.randomUUID().toString(), hotelRoomDto.getHotelId(), hotelRoomDto.getNumber(),
                spaces, hotelRoomDto.getDescription());
    }
}
