package pl.dkiszka.rentalapplication.domain.booking;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookingAccepted implements DomainEvent {

    static BookingAccepted create(RentalType rentalType, String rentalPlaceId, String tenantId, List<LocalDate> days) {
        return new BookingAccepted(UUID.randomUUID().toString(), LocalDateTime.now(), rentalType.name(), rentalPlaceId, tenantId, days);
    }

    private final String eventId;
    private final LocalDateTime eventCreationDateTime;
    private final String rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;
}
