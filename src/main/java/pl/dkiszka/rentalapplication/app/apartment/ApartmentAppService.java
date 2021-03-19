package pl.dkiszka.rentalapplication.app.apartment;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentFactory;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;

import java.util.Map;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class ApartmentAppService {
    private final ApartmentRepository apartmentRepository;

    public void add(String ownerId, String street, String postalCode, String houseNumber, String apartmentNumber, String city, String country,
                    String description, Map<String, Double> roomsDefinition) {
        var apartment = new ApartmentFactory().create(ownerId, street, postalCode, houseNumber, apartmentNumber, city, country, description, roomsDefinition);
        apartmentRepository.save(apartment);
    }
}
