package pl.dkiszka.rentalapplication.adapters.persistence.jpa.apartmentbookinghistory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistory;
import pl.dkiszka.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistoryRepository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
class JpaApartmentBookingHistoryRepository implements ApartmentBookingHistoryRepository {

    private final SpringJpaApartmentBookingHistoryRepository springJpaApartmentBookingHistoryRepository;

    @Override
    public Optional<ApartmentBookingHistory> findByApartmentId(String apartmentId) {
        return springJpaApartmentBookingHistoryRepository.findByApartmentId(apartmentId);
    }

    @Override
    public ApartmentBookingHistory save(ApartmentBookingHistory apartmentBookingHistory) {
        return springJpaApartmentBookingHistoryRepository.save(apartmentBookingHistory);
    }
}

interface SpringJpaApartmentBookingHistoryRepository extends Repository<ApartmentBookingHistory, String> {
    Optional<ApartmentBookingHistory> findByApartmentId(String apartmentId);

    ApartmentBookingHistory save(ApartmentBookingHistory apartmentBookingHistory);
}
