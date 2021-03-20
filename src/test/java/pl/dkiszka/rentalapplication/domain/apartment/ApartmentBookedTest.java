package pl.dkiszka.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;
import pl.dkiszka.rentalapplication.domain.booking.Period;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
class ApartmentBookedTest {

    private final String APARTMENT_ID = UUID.randomUUID().toString();
    private final String OWNER_ID = UUID.randomUUID().toString();
    private final String TENANT_ID = UUID.randomUUID().toString();
    private final LocalDate periodStart = LocalDate.now().minusDays(5);
    private final LocalDate periodEnd = LocalDate.now().minusDays(1);
    private final Period PERIOD = new Period(periodStart, periodEnd);

    @Test
    void should_create_event_with_all_information() {
        var actual = ApartmentBooked.create(APARTMENT_ID, OWNER_ID, TENANT_ID, PERIOD);

        ApartmentBookedAssertion.assertThat(actual)
                .hasApartmentIdEqualsTo(APARTMENT_ID)
                .hasOwnerIdEqualsTo(OWNER_ID)
                .hasTenantdEqualsTo(TENANT_ID)
                .hasPeriodEqualsTo(PERIOD)
                .hasContainEventIdCompatibleWithPattern();
    }
}
