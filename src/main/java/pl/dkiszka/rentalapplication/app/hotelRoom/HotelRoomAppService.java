package pl.dkiszka.rentalapplication.app.hotelRoom;

import pl.dkiszka.rentalapplication.domain.hotelRoom.HotelRoomFactory;

import java.util.Map;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public class HotelRoomAppService {
    public void add(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        new HotelRoomFactory().create(hotelId, number, spacesDefinition, description);
    }
}
