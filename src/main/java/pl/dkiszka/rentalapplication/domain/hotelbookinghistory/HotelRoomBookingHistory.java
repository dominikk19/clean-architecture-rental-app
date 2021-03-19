package pl.dkiszka.rentalapplication.domain.hotelbookinghistory;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HotelRoomBookingHistory {
    @Id
    private String hotelRoomId;

    @OneToMany
    private final List<HotelRoomBooking> bookings = Lists.newArrayList();

    HotelRoomBookingHistory(String hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    boolean hasIdEqualTo(String hotelRoomId) {
        return this.hotelRoomId.equals(hotelRoomId);
    }

    void add(LocalDateTime bookingDateTime, String tenantId, List<LocalDate> days) {
        bookings.add(new HotelRoomBooking(bookingDateTime, tenantId, days));
    }
}
