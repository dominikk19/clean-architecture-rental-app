package pl.dkiszka.rentalapplication.domain.hotelbookinghistory;

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
class HotelRoomBooking {
    private final LocalDateTime bookingDateTime;
    private final String tenantId;
    private final List<LocalDate> days;
}
