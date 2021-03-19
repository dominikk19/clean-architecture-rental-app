package pl.dkiszka.rentalapplication.app.hotelroom;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomFactory;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.util.Map;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class HotelRoomAppService {

    private final HotelRoomRepository hotelRoomRepository;

    public void add(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        var hotelRoom = new HotelRoomFactory().create(hotelId, number, spacesDefinition, description);
        hotelRoomRepository.save(hotelRoom);
    }
}
