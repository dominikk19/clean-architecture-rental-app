package pl.dkiszka.rentalapplication.domain.booking;

import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface BookingRepository {
    Booking save(Booking booking);

    Optional<Booking> findByUuid(String uuid);
}
