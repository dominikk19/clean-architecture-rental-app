package pl.dkiszka.rentalapplication.adapters.eventlisteners.hotelbookinghistory;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import pl.dkiszka.rentalapplication.app.hotelbookinghistory.HotelBookingHistoryAppService;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomBooked;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
class HotelBookingHistoryEventListener {
    private final HotelBookingHistoryAppService hotelBookingHistoryAppService;

    @EventListener
    public void consume(HotelRoomBooked hotelRoomBooked) {
        hotelBookingHistoryAppService.consume(hotelRoomBooked);
    }
}
