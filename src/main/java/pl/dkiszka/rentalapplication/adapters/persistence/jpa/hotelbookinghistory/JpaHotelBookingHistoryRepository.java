package pl.dkiszka.rentalapplication.adapters.persistence.jpa.hotelbookinghistory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.hotelbookinghistory.HotelBookingHistory;
import pl.dkiszka.rentalapplication.domain.hotelbookinghistory.HotelBookingHistoryRepository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
class JpaHotelBookingHistoryRepository implements HotelBookingHistoryRepository {

    private final SpringJpaHotelBookingHistoryRepository springJpaHotelBookingHistoryRepository;

    @Override
    public Optional<HotelBookingHistory> findByHotelId(String hotelId) {
        return springJpaHotelBookingHistoryRepository.findByHotelId(hotelId);
    }

    @Override
    public void save(HotelBookingHistory hotelBookingHistory) {
        springJpaHotelBookingHistoryRepository.save(hotelBookingHistory);
    }
}

interface SpringJpaHotelBookingHistoryRepository extends Repository<HotelBookingHistory, String> {
    Optional<HotelBookingHistory> findByHotelId(String hotelId);

    HotelBookingHistory save(HotelBookingHistory hotelBookingHistory);
}
