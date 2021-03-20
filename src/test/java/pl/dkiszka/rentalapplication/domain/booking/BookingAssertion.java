package pl.dkiszka.rentalapplication.domain.booking;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class BookingAssertion {

    static BookingAssertion assertThat(Booking actual) {
        return new BookingAssertion(actual);
    }

    private final Booking actual;

    BookingAssertion hasBookingStatusEqualTo(BookingStatus expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStatus", expected);
        return this;
    }

    BookingAssertion hasRentalTypeEqualTo(RentalType rentalType) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", rentalType);
        return this;
    }

    BookingAssertion hasRentalPlaceIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId", expected);
        return this;
    }

    BookingAssertion hasTenantIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    BookingAssertion containsAllDays(List<LocalDate> expected) {
        Assertions.assertThat(actual)
                .extracting("days")
                .satisfies(days -> {
                    var actualDays = (List<LocalDate>) days;
                    Assertions.assertThat(actualDays).containsExactlyElementsOf(expected);
                });
        return this;
    }
}
