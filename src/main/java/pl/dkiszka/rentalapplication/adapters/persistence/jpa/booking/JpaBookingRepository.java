package pl.dkiszka.rentalapplication.adapters.persistence.jpa.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.booking.Booking;
import pl.dkiszka.rentalapplication.domain.booking.BookingRepository;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
class JpaBookingRepository implements BookingRepository {

    private final SpringJpaBookingRepository springJpaBookingRepository;

    @Override
    public Booking save(Booking booking) {
        return springJpaBookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findByUuid(String uuid) {
        return springJpaBookingRepository.findByUuid(uuid);
    }
}

interface SpringJpaBookingRepository extends Repository<Booking, String> {
    Booking save(Booking booking);

    Optional<Booking> findByUuid(String uuid);
}
