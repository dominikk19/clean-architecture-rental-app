package pl.dkiszka.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dkiszka.rentalapplication.adapters.rest.api.apartment.ApartmentDto;
import pl.dkiszka.rentalapplication.domain.booking.Period;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
class ApartmentTest {
    private static final String OWNER_ID = UUID.randomUUID().toString();
    private static final String STREET = "Jerozolimskie";
    private static final String POSTAL_CODE = "02-123";
    private static final String HOUSE_NUMBER = "12";
    private static final String APARTMENT_NUMBER = "33";
    private static final String CITY = "Warsaw";
    private static final String COUNTRY = "Poland";
    private static final String DESCRIPTION = "some text";
    private static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of("Toilet", 10.0, "Bedroom", 30.0);
    private static final LocalDate START = LocalDate.of(2020, 3, 4);
    private static final LocalDate MIDDLE = LocalDate.of(2020, 3, 5);
    private static final LocalDate END = LocalDate.of(2020, 3, 6);
    private static final String TENANT_ID = UUID.randomUUID().toString();
    private static final Period PERIOD = new Period(START, END);

    private final ApartmentEventsPublisher publisher = Mockito.mock(ApartmentEventsPublisher.class);


    @Test
    void should_create_apartment_with_all_requier_fields() {
        var apartmentDto = new ApartmentDto(OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY, DESCRIPTION, ROOMS_DEFINITION);
        var actual = ApartmentFactory.create(apartmentDto);

        ApartmentAssertion.assertThat(actual)
                .hasOwnerIdEqualsTo(OWNER_ID)
                .hasAddressEqualsTo(STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY)
                .hasDescriptionEqualsTo(DESCRIPTION)
                .hasRoomsEqualsTo(ROOMS_DEFINITION);
    }

    @Test
    void should_create_booking_once_booked() {
        var apartmentDto = new ApartmentDto(OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY, DESCRIPTION, ROOMS_DEFINITION);
        var apartment = ApartmentFactory.create(apartmentDto);

        var actual = apartment.book(TENANT_ID, PERIOD, publisher);

        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("tenantId", TENANT_ID);
    }

    @Test
    void should_publish_apartment_booked() {
        var apartmentDto = new ApartmentDto(OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY, DESCRIPTION, ROOMS_DEFINITION);
        var apartment = ApartmentFactory.create(apartmentDto);

        apartment.book(TENANT_ID, PERIOD, publisher);

        Mockito.verify(publisher).publishApartmentBooked(any(), eq(OWNER_ID), eq(TENANT_ID), eq(PERIOD));
    }
}
