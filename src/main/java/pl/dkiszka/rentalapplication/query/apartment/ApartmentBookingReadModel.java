package pl.dkiszka.rentalapplication.query.apartment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
//@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentBookingReadModel {
    private String bookingStep;
    private LocalDateTime bookingDateTime;
    private String ownerId;
    private String tenantId;
    private LocalDate periodStart;
    private LocalDate periodEnd;
}
