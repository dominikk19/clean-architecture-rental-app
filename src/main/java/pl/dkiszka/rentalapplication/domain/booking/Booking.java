package pl.dkiszka.rentalapplication.domain.booking;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@RequiredArgsConstructor
public class Booking {

    public static Booking apartment(String rentalPlaceId, String tenantId, Period period) {
        return new Booking(UUID.randomUUID().toString(), RentalType.APARTMENT, rentalPlaceId, tenantId, period.asDays());
    }

    public static Booking hotelRoom(String rentalPlaceId, String tenantId, List<LocalDate> days) {
        return new Booking(UUID.randomUUID().toString(), RentalType.HOTEL_ROOM, rentalPlaceId, tenantId, days);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private final String uuid;
    private final RentalType rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;
    private BookingStatus bookingStatus = BookingStatus.OPEN;


    public void reject() {
        bookingStatus = BookingStatus.REJECTED;
    }

    public void accept(DomainEventChannel eventChannel) {
        bookingStatus = BookingStatus.ACCEPTED;

        var bookingAccepted = BookingAccepted.create(rentalType, rentalPlaceId, tenantId, days);
        eventChannel.publish(bookingAccepted);
    }
}
