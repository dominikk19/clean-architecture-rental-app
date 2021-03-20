package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentBookingHistoryAssertion {

    static ApartmentBookingHistoryAssertion assertThat(ApartmentBookingHistory actual) {
        return new ApartmentBookingHistoryAssertion(actual);
    }

    private final ApartmentBookingHistory actual;

    ApartmentBookingHistoryAssertion hasApartmentIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("apartmentId", expected);
        return this;
    }

    ApartmentBookingHistoryAssertion hasApartmentBookingsAmount(int expected) {
        hasApartmentBookings()
                .satisfies(actualBookings -> {
            Assertions.assertThat((List<ApartmentBooking>) actualBookings).hasSize(expected);
        });
        return this;
    }

    ApartmentBookingHistoryAssertion hasApartmentBookingThatSatisfies(Consumer<ApartmentBooking> requirements) {
        hasApartmentBookings()
                .satisfies(actualBookings -> {
            Assertions.assertThat((List<ApartmentBooking>) actualBookings).anySatisfy(requirements);
        });
        return this;
    }

    private AbstractObjectAssert<?, ?> hasApartmentBookings() {
        return Assertions.assertThat(actual).extracting("bookings");
    }


}
