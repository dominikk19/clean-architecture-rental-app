package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApartmentBooking {

    public static ApartmentBooking start(LocalDateTime bookingDateTime, String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        return new ApartmentBooking(BookingStep.START, bookingDateTime, ownerId, tenantId, bookingPeriod);
    }

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private BookingStep bookingStep;
    private LocalDateTime bookingDateTime;
    private String ownerId;
    private String tenantId;

    @Embedded
    private BookingPeriod bookingPeriod;

    private ApartmentBooking(BookingStep bookingStep, LocalDateTime bookingDateTime, String ownerId, String tenantId, BookingPeriod bookingPeriod) {
        this.bookingStep = bookingStep;
        this.bookingDateTime = bookingDateTime;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.bookingPeriod = bookingPeriod;
    }
}
