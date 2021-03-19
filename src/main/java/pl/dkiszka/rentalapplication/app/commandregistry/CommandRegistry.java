package pl.dkiszka.rentalapplication.app.commandregistry;

import pl.dkiszka.rentalapplication.app.booking.BookingAccept;
import pl.dkiszka.rentalapplication.app.booking.BookingReject;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface CommandRegistry {
    void register(BookingReject bookingReject);

    void register(BookingAccept bookingAccept);
}
