package pl.dkiszka.rentalapplication.domain.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
class PeriodTest {
    private static final LocalDate START = LocalDate.of(2020, 10, 11);
    private static final LocalDate END = LocalDate.of(2021, 10, 11);

    @ParameterizedTest
    @MethodSource("daysBetweenStartAndEnd")
    void should_return_all_days_between_start_and_end(LocalDate start, LocalDate end, Iterable<LocalDate> expected) {
        var actual = new Period(start, end).asDays();

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> daysBetweenStartAndEnd() {
        return Stream.of(
                Arguments.of(
                        LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 3),
                        asList(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2), LocalDate.of(2020, 1, 3))),
                Arguments.of(
                        LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 2),
                        asList(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 2))),
                Arguments.of(
                        LocalDate.of(2020, 5, 5), LocalDate.of(2020, 5, 10),
                        asList(
                                LocalDate.of(2020, 5, 5), LocalDate.of(2020, 5, 6), LocalDate.of(2020, 5, 7),
                                LocalDate.of(2020, 5, 8), LocalDate.of(2020, 5, 9), LocalDate.of(2020, 5, 10)))
        );
    }

    @Test
    void should_return_one_date_when_start_and_end_are_the_same() {
        var date = LocalDate.of(2020, 10, 11);
        var actual = new Period(date, date).asDays();

        assertThat(actual).containsExactly(date);
    }

}
