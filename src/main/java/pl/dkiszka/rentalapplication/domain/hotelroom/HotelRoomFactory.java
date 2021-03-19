package pl.dkiszka.rentalapplication.domain.hotelroom;

import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public class HotelRoomFactory {
    public HotelRoom create(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        var spaces = spacesDefinition.entrySet().stream()
                .map(entry -> {
                    SquareMeter squareMeter = new SquareMeter(entry.getValue());
                    return new Space(entry.getKey(), squareMeter);
                })
                .collect(toList());
        return new HotelRoom(UUID.randomUUID().toString(), hotelId, number, spaces, description);
    }
}
