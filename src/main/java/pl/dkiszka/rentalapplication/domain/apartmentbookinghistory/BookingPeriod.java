package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingPeriod {
    private LocalDate periodStart;
    private LocalDate periodEnd;

    public BookingPeriod(LocalDate periodStart, LocalDate periodEnd) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }
}
