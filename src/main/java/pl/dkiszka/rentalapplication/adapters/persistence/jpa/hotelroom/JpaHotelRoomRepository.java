package pl.dkiszka.rentalapplication.adapters.persistence.jpa.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoom;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.util.Optional;

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

    @Override
    public HotelRoom findByUuid(String uuid) {
        return springJpaHotelRoomRepository.findByUuid(uuid)
                .orElseThrow(()->new HotelRoomNotFoundException(String.format("Hotel room by uuid: %s not exists", uuid)));
    }
}

interface SpringJpaHotelRoomRepository extends Repository<HotelRoom, String> {
    HotelRoom save(HotelRoom hotelRoom);
    Optional<HotelRoom> findByUuid(String uuid);
}
