package pl.dkiszka.rentalapplication.app.hotelbookinghistory;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.hotelbookinghistory.HotelBookingHistory;
import pl.dkiszka.rentalapplication.domain.hotelbookinghistory.HotelBookingHistoryRepository;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomBooked;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class HotelBookingHistoryAppService {

    private final HotelBookingHistoryRepository hotelBookingHistoryRepository;

    public void consume(HotelRoomBooked hotelRoomBooked) {
        var hotelBookingHistory = hotelBookingHistoryRepository.findByHotelId(hotelRoomBooked.getHotelId())
                .orElse(new HotelBookingHistory(hotelRoomBooked.getHotelId()));
        hotelBookingHistory.add(
                hotelRoomBooked.getHotelRoomId(), hotelRoomBooked.getEventCreationDateTime(), hotelRoomBooked.getTenantId(),
                hotelRoomBooked.getDays());
        hotelBookingHistoryRepository.save(hotelBookingHistory);

    }
}
