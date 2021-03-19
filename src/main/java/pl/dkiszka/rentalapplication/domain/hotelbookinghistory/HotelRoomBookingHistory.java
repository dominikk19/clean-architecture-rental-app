package pl.dkiszka.rentalapplication.domain.hotelbookinghistory;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
class HotelRoomBookingHistory {
    private final String hotelRoomId;
    private final List<HotelRoomBooking> bookings = Lists.newArrayList();

    boolean hasIdEqualTo(String hotelRoomId) {
        return this.hotelRoomId.equals(hotelRoomId);
    }

    void add(LocalDateTime bookingDateTime, String tenantId, List<LocalDate> days) {
        bookings.add(new HotelRoomBooking(bookingDateTime, tenantId, days));
    }
}
