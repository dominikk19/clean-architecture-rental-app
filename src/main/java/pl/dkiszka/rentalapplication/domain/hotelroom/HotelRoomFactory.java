package pl.dkiszka.rentalapplication.domain.hotelroom;

import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class HotelRoomFactory {

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static HotelRoom create(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        var spaces = spacesDefinition.entrySet().stream()
                .map(entry -> new Space(entry.getKey(), entry.getValue()))
                .collect(toList());
        return new HotelRoom(UUID.randomUUID().toString(), hotelId, number, spaces, description);
    }
}
