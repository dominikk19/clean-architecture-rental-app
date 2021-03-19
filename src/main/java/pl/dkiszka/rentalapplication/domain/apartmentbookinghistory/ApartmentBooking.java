package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApartmentBooking {

    public static ApartmentBooking start(LocalDateTime bookingDateTime, String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        return new ApartmentBooking(BookingStep.START, bookingDateTime, ownerId, tenantId, bookingPeriod);
    }

    private final BookingStep bookingStep;
    private final LocalDateTime bookingDateTime;
    private final String ownerId;
    private final String tenantId;
    private final BookingPeriod bookingPeriod;
}
