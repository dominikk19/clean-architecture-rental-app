package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class BookingPeriod {
    private final LocalDate periodStart;
    private final LocalDate periodEnd;
}
