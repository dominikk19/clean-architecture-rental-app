package pl.dkiszka.rentalapplication.domain.apartmentoffert;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApartmentAvailability {

    public static ApartmentAvailability of(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new ApartmentAvailabilityException(String.format("Start date: %s is after of end: %2s", start, end));
        }
        return new ApartmentAvailability(start, end);
    }

    private final LocalDate start;
    private final LocalDate end;

}
