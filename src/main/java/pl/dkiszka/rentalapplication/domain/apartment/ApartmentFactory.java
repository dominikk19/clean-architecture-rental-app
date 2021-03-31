package pl.dkiszka.rentalapplication.domain.apartment;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class ApartmentFactory {

    public static Apartment create(ApartmentDto apartmentDto) {
        var address = Address.builder()
                .street(apartmentDto.getStreet())
                .postalCode(apartmentDto.getPostalCode())
                .houseNumber(apartmentDto.getHouseNumber())
                .apartmentNumber(apartmentDto.getApartmentNumber())
                .city(apartmentDto.getCity())
                .country(apartmentDto.getCountry())
                .build();
        var rooms = apartmentDto.getRoomsDefinition().entrySet()
                .stream()
                .map(entry -> {
                    var squareMeter = new SquareMeter(entry.getValue());
                    return new Room(entry.getKey(), squareMeter);
                })
                .collect(toList());
        return Apartment.builder()
                .ownerId(apartmentDto.getOwnerId())
                .address(address)
                .rooms(rooms)
                .description(apartmentDto.getDescription()).build();
    }
}
