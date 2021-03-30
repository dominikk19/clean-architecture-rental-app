package pl.dkiszka.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.Period;
import pl.dkiszka.rentalapplication.domain.events.EventUuidFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 30.03.2021
 */
class ApartmentEventsPublisherTest {
    private final DomainEventChannel domainPublisher = mock(DomainEventChannel.class);
    private final ApartmentEventsPublisher publisher = new ApartmentEventsPublisher(new EventUuidFactory(), domainPublisher);

    @Test
    void should_create_apartment_booked_event() {
        ArgumentCaptor<ApartmentBooked> captor = ArgumentCaptor.forClass(ApartmentBooked.class);
        var apartmentId = "123123";
        var ownerId = "7686";
        var tenantId = "68678";
        var beforeNow = LocalDateTime.now().minusNanos(1);
        var periodStart = LocalDate.of(2020, 10, 11);
        var periodEnd = LocalDate.of(2020, 10, 18);
        var period = new Period(periodStart, periodEnd);

        publisher.publishApartmentBooked(apartmentId, ownerId, tenantId, period);
        then(domainPublisher).should().publish(captor.capture());

        var actual = captor.getValue();

        assertThat(actual.getEventUuid()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        assertThat(actual.getEventCreationDateTime())
                .isAfter(beforeNow)
                .isBefore(LocalDateTime.now().plusNanos(1));
        assertThat(actual.getApartmentId()).isEqualTo(apartmentId);
        assertThat(actual.getOwnerId()).isEqualTo(ownerId);
        assertThat(actual.getTenantId()).isEqualTo(tenantId);
        assertThat(actual.getPeriodStart()).isEqualTo(periodStart);
        assertThat(actual.getPeriodEnd()).isEqualTo(periodEnd);
    }

}
