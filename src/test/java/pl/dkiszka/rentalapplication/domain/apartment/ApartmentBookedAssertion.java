package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.dkiszka.rentalapplication.domain.booking.Period;

import java.util.regex.Pattern;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ApartmentBookedAssertion {

    static ApartmentBookedAssertion assertThat(ApartmentBooked actual) {
        return new ApartmentBookedAssertion(actual);
    }

    private final ApartmentBooked actual;

    ApartmentBookedAssertion hasEventUuidEqualsTo(String expected) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("eventUuid", expected);
        return this;
    }


    ApartmentBookedAssertion hasApartmentIdEqualsTo(String expected) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("apartmentId", expected);
        return this;
    }

    ApartmentBookedAssertion hasOwnerIdEqualsTo(String expected) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("ownerId", expected);
        return this;
    }

    ApartmentBookedAssertion hasTenantdEqualsTo(String expected) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    ApartmentBookedAssertion hasPeriodEqualsTo(Period expected) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("periodStart", expected.getStart())
                .hasFieldOrPropertyWithValue("periodEnd", expected.getEnd());
        return this;
    }

    ApartmentBookedAssertion hasContainEventIdCompatibleWithPattern() {
        Assertions.assertThat(actual.getEventUuid()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        return this;
    }
}
