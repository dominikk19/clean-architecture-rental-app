package pl.dkiszka.rentalapplication.adapters.eventlisteners.apartmentbookinghistory;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.dkiszka.rentalapplication.app.apartmentbookinghistory.ApartmentBookingHistoryAppService;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentBooked;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Component
@RequiredArgsConstructor
class ApartmentBookingHistoryEventListener {
    private final ApartmentBookingHistoryAppService apartmentBookingHistoryAppService;

    @EventListener
    public void consume(ApartmentBooked apartmentBooked) {
        apartmentBookingHistoryAppService.consume(apartmentBooked);
    }

}
