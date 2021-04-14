package pl.dkiszka.rentalapplication.app.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dkiszka.rentalapplication.domain.hotel.HotelDto;
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

    public String add(HotelDto hotelDto) {
        var hotel = HotelFactory.create(hotelDto);
        return hotelRepository.save(hotel).uuid();
    }
}
