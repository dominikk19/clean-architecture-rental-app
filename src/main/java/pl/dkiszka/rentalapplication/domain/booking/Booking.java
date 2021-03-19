package pl.dkiszka.rentalapplication.domain.booking;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
    private String uuid;

    @Enumerated(EnumType.STRING)
    private RentalType rentalType;
    private String rentalPlaceId;
    private String tenantId;

    @ElementCollection
    private List<LocalDate> days;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.OPEN;


    private Booking(String uuid, RentalType rentalType, String rentalPlaceId, String tenantId, List<LocalDate> days) {
        this.uuid = uuid;
        this.rentalType = rentalType;
        this.rentalPlaceId = rentalPlaceId;
        this.tenantId = tenantId;
        this.days = days;
    }

    public void reject() {
        bookingStatus = BookingStatus.REJECTED;
    }

    public void accept(DomainEventChannel eventChannel) {
        bookingStatus = BookingStatus.ACCEPTED;

        var bookingAccepted = BookingAccepted.create(rentalType, rentalPlaceId, tenantId, days);
        eventChannel.publish(bookingAccepted);
    }
}
