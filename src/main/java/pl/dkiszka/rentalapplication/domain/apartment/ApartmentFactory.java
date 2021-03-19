package pl.dkiszka.rentalapplication.domain.apartment;

import java.util.Map;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public class ApartmentFactory {

    public Apartment create(String ownerId, String street, String postalCode, String houseNumber, String apartmentNumber, String city,
                            String country, String description, Map<String, Double> roomsDefinition) {
        var address = new Address(street, postalCode, houseNumber, apartmentNumber, city, country);
        var rooms = roomsDefinition.entrySet()
                .stream()
                .map(roomDef -> {
                    var squareMeter = new SquareMeter(roomDef.getValue());
                    return new Room(roomDef.getKey(), squareMeter);
                })
                .collect(toList());

        return new Apartment(UUID.randomUUID().toString(), ownerId, address, rooms, description);
    }
}
