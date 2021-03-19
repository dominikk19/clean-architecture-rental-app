package pl.dkiszka.rentalapplication.query.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.query.hotelroom.dto.HotelRoomReadModelDto;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class QueryHotelRoomRepository {
    private final SpringJpaQueryHotelRoomRepository springJpaQueryHotelRoomRepository;

    public List<HotelRoomReadModelDto> findAllByHotelId(String hotelId) {
        return springJpaQueryHotelRoomRepository.findAllByHotelId(hotelId);
    }
}

interface SpringJpaQueryHotelRoomRepository extends Repository<HotelRoomReadModel, String> {
    List<HotelRoomReadModelDto> findAllByHotelId(String hotelId);
}
