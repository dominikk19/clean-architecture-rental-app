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
public class HotelBookingHistory {
    @Id
    private String hotelId;

    @OneToMany
    private List<HotelRoomBookingHistory> hotelRoomBookingHistories = Lists.newArrayList();

    public HotelBookingHistory(String hotelId) {
        this.hotelId = hotelId;
    }

    public void add(String hotelRoomId, LocalDateTime bookingDateTime, String tenantId, List<LocalDate> days) {
        HotelRoomBookingHistory hotelRoomBookingHistory = findFor(hotelRoomId);
        hotelRoomBookingHistory.add(bookingDateTime, tenantId, days);
    }

    private HotelRoomBookingHistory findFor(String hotelRoomId) {
        return hotelRoomBookingHistories.stream()
                .filter(hotelRoomBookingHistory -> hotelRoomBookingHistory.hasIdEqualTo(hotelRoomId))
                .findFirst()
                .orElseGet(() -> {
                    var hotelRoomBookingHistory = new HotelRoomBookingHistory(hotelRoomId);
                    hotelRoomBookingHistories.add(hotelRoomBookingHistory);
                    return hotelRoomBookingHistory;
                });
    }
}
