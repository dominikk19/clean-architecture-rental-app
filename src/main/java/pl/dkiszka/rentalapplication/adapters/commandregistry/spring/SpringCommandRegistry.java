package pl.dkiszka.rentalapplication.adapters.commandregistry.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import pl.dkiszka.rentalapplication.app.booking.BookingAccept;
import pl.dkiszka.rentalapplication.app.booking.BookingReject;
import pl.dkiszka.rentalapplication.app.commandregistry.CommandRegistry;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */

@RequiredArgsConstructor
class SpringCommandRegistry implements CommandRegistry {
    private final ApplicationEventPublisher publisher;

    @Override
    public void register(BookingReject bookingReject) {
        publisher.publishEvent(bookingReject);
    }

    @Override
    public void register(BookingAccept bookingAccept) {
        publisher.publishEvent(bookingAccept);
    }
}
