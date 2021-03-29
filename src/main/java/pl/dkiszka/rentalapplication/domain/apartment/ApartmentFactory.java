package pl.dkiszka.rentalapplication.domain.apartment;

import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class ApartmentFactory {

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static Apartment create(String ownerId, String street, String postalCode, String houseNumber, String apartmentNumber, String city,
                            String country, String description, Map<String, Double> roomsDefinition) {
        var address = new Address(street, postalCode, houseNumber, apartmentNumber, city, country);
        var rooms = roomsDefinition.entrySet()
                .stream()
                .map(entry -> {
                    var squareMeter = new SquareMeter(entry.getValue());
                    return new Room(entry.getKey(), squareMeter);
                })
                .collect(toList());
        return new Apartment(UUID.randomUUID().toString(), ownerId, address, rooms, description);
    }
}
