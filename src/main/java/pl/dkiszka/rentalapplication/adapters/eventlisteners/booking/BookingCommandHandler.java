package pl.dkiszka.rentalapplication.adapters.eventlisteners.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.dkiszka.rentalapplication.app.booking.BookingAccept;
import pl.dkiszka.rentalapplication.app.booking.BookingAppService;
import pl.dkiszka.rentalapplication.app.booking.BookingReject;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Component
@RequiredArgsConstructor
class BookingCommandHandler {

    private final BookingAppService bookingAppService;

    @EventListener
    public void reject(BookingReject bookingReject) {
        bookingAppService.reject(bookingReject);
    }

    @EventListener
    public void accept(BookingAccept bookingAccept) {
        bookingAppService.accept(bookingAccept);
    }
}
