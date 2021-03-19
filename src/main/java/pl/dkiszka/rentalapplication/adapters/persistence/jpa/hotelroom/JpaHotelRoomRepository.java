package pl.dkiszka.rentalapplication.adapters.persistence.jpa.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoom;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
class JpaHotelRoomRepository implements HotelRoomRepository {

    private final SpringJpaHotelRoomRepository springJpaHotelRoomRepository;

    @Override
    public HotelRoom save(HotelRoom hotelRoom) {
        return springJpaHotelRoomRepository.save(hotelRoom);
    }
}

interface SpringJpaHotelRoomRepository extends Repository<HotelRoom, Long> {
    HotelRoom save(HotelRoom hotelRoom);
}
