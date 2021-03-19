package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentBooked implements DomainEvent {

    static ApartmentBooked create(String apartmentId, String ownerId, String tenantId, Period period) {
        return new ApartmentBooked(UUID.randomUUID().toString(), LocalDateTime.now(), apartmentId, ownerId, tenantId, period.getStart(), period.getEnd());
    }

    private final String eventUuid;
    private final LocalDateTime eventCreationDateTime;
    private final String apartmentId;
    private final String ownerId;
    private final String tenantId;
    private final LocalDate periodStart;
    private final LocalDate periodEnd;
}
