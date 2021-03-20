package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentBookingAssertion {

    static ApartmentBookingAssertion assertThat(ApartmentBooking actual) {
        return new ApartmentBookingAssertion(actual);
    }
    private final ApartmentBooking actual;

    ApartmentBookingAssertion isStart() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStep", BookingStep.START);
        return this;
    }

    ApartmentBookingAssertion hasBookingDateTimeEqualTo(LocalDateTime expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingDateTime", expected);
        return this;
    } 

    ApartmentBookingAssertion hasOwnerIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId", expected);
        return this;
    }

    ApartmentBookingAssertion hasTenantIdEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    ApartmentBookingAssertion hasBookingPeriodThatHas(LocalDate expectedStart, LocalDate expectedEnd) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("bookingPeriod.periodStart", expectedStart)
                .hasFieldOrPropertyWithValue("bookingPeriod.periodEnd", expectedEnd);
        return this;
    }
}
