package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface ApartmentBookingHistoryRepository {
    Optional<ApartmentBookingHistory> findByApartmentId(String apartmentId);

    ApartmentBookingHistory save(ApartmentBookingHistory apartmentBookingHistory);
}
