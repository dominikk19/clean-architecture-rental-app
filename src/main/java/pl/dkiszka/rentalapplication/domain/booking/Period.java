package pl.dkiszka.rentalapplication.domain.booking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
@Getter
public class Period {
    private final LocalDate start;
    private final LocalDate end;

    List<LocalDate> asDays() {
        var dates = start.datesUntil(end).collect(toList());
        dates.add(end);
        return dates;
    }
}
