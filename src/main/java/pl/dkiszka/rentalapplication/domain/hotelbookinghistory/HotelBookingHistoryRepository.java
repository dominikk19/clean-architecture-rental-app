package pl.dkiszka.rentalapplication.domain.hotelbookinghistory;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface HotelBookingHistoryRepository {
    Optional<HotelBookingHistory> findByHotelId(String hotelId);

    void save(HotelBookingHistory hotelBookingHistory);
}
