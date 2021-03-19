package pl.dkiszka.rentalapplication.query.apartment.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface ApartmentBookingReadModelDto {
    String getBookingStep();

    LocalDateTime getBookingDateTime();

    String getOwnerId();

    String getTenantId();

    LocalDate getPeriodStart();

    LocalDate getPeriodEnd();
}
