package pl.dkiszka.rentalapplication.adapters.persistence.jpa.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.hotel.Hotel;
import pl.dkiszka.rentalapplication.domain.hotel.HotelRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
class JpaHotelRepository implements HotelRepository {

    private final SpringJpaHotelRepository springJpaHotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        return springJpaHotelRepository.save(hotel);
    }
}

interface SpringJpaHotelRepository extends Repository<Hotel, String> {
    Hotel save(Hotel hotel);
}
