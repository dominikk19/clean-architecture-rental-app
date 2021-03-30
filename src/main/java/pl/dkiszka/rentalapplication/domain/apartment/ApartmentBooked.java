package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEvent;
import pl.dkiszka.rentalapplication.domain.booking.Period;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApartmentBooked implements DomainEvent {

    @SuppressWarnings("checkstyle:ParameterNumber")
    static ApartmentBooked create(String eventUuid, String apartmentId, String ownerId, String tenantId, Period period) {
        return new ApartmentBooked(eventUuid,
                LocalDateTime.now(), apartmentId, ownerId, tenantId, period.getStart(), period.getEnd());
    }

    private final String eventUuid;
    private final LocalDateTime eventCreationDateTime;
    private final String apartmentId;
    private final String ownerId;
    private final String tenantId;
    private final LocalDate periodStart;
    private final LocalDate periodEnd;
}
