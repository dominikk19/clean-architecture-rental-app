package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class Booking {

    static Booking apartment(String rentalPlaceId, String tenantId, Period period) {
        return new Booking(RentalType.APARTMENT, rentalPlaceId, tenantId, period.asDays());
    }

    public static Booking hotelRoom(String rentalPlaceId, String tenantId, List<LocalDate> days) {
        return new Booking(RentalType.HOTEL_ROOM, rentalPlaceId, tenantId, days);
    }

    private final RentalType rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;
    private BookingStatus bookingStatus = BookingStatus.OPEN;
}
