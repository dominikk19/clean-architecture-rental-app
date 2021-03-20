package pl.dkiszka.rentalapplication.app.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dkiszka.rentalapplication.domain.hotel.HotelFactory;
import pl.dkiszka.rentalapplication.domain.hotel.HotelRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Service
@RequiredArgsConstructor
public class HotelAppService {

    private final HotelRepository hotelRepository;

    public void add(String name, String street, String postalCode, String buildingNumber, String city, String country) {
        var hotel = new HotelFactory().create(name, street, postalCode, buildingNumber, city, country);
        hotelRepository.save(hotel);
    }
}
