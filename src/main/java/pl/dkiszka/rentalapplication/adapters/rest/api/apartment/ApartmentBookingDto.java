package pl.dkiszka.rentalapplication.adapters.rest.api.apartment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
class ApartmentBookingDto {
    private final String tenantId;
    private final LocalDate start;
    private final LocalDate end;
}
