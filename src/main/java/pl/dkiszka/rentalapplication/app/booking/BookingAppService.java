package pl.dkiszka.rentalapplication.app.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.BookingRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Service
@RequiredArgsConstructor
public class BookingAppService {
    private final BookingRepository bookingRepository;
    private final DomainEventChannel eventChannel;

    public void reject(BookingReject bookingReject) {

        bookingRepository.findByUuid(bookingReject.getUuid())
                .ifPresent(it -> {
                    it.reject();
                    bookingRepository.save(it);
                });
    }

    public void accept(BookingAccept bookingAccept) {
        bookingRepository.findByUuid(bookingAccept.getUuid())
                .ifPresent(it -> {
                    it.accept(eventChannel);
                    bookingRepository.save(it);
                });
    }
}
