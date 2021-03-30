package pl.dkiszka.rentalapplication.domain.hotelroom;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.events.EventUuidFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 30.03.2021
 */
class HotelRoomEventsPublisherTest {

    private final DomainEventChannel domainPublisher = mock(DomainEventChannel.class);
    private final HotelRoomEventsPublisher publisher = new HotelRoomEventsPublisher(new EventUuidFactory(), domainPublisher);

    @Test
    void should_create_apartment_booked_event() {
        ArgumentCaptor<HotelRoomBooked> captor = ArgumentCaptor.forClass(HotelRoomBooked.class);
        var hotelRoomId = "1234";
        var hotelId = "5678";
        var tenantId = "3456";
        var beforeNow = LocalDateTime.now().minusNanos(1);
        var days = asList(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2), LocalDate.of(2020, 1, 3));

        publisher.publishHotelRoomBooked(hotelRoomId, hotelId, tenantId, days);
        then(domainPublisher).should().publish(captor.capture());

        var actual = captor.getValue();

        assertThat(actual.getEventUuid()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        assertThat(actual.getEventCreationDateTime())
                .isAfter(beforeNow)
                .isBefore(LocalDateTime.now().plusNanos(1));
        assertThat(actual.getHotelRoomId()).isEqualTo(hotelRoomId);
        assertThat(actual.getHotelId()).isEqualTo(hotelId);
        assertThat(actual.getTenantId()).isEqualTo(tenantId);
        assertThat(actual.getDays()).containsExactlyElementsOf(days);
    }


}
