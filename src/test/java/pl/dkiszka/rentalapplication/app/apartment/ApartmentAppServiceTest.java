package pl.dkiszka.rentalapplication.app.apartment;

import com.google.common.collect.ImmutableMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentFactory;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;
import pl.dkiszka.rentalapplication.domain.booking.Booking;
import pl.dkiszka.rentalapplication.domain.booking.BookingRepository;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
class ApartmentAppServiceTest {

    private static final String OWNER_ID = "1234";
    private static final String STREET = "Długa";
    private static final String POSTAL_CODE = "01-111";
    private static final String HOUSE_NUMBER = "14";
    private static final String APARTMENT_NUMBER = "2";
    private static final String CITY = "Warsaw";
    private static final String COUNTRY = "Poland";
    private static final String DESCRIPTION = "Some description";
    private static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of("Bedroom", 22.0, "Toilet", 5.0);
    private static final String TENANT_ID = "137";
    private static final LocalDate START = LocalDate.of(2020, 3, 4);
    private static final LocalDate END = LocalDate.of(2020, 3, 6);

    private final ApartmentRepository apartmentRepository = mock(ApartmentRepository.class);
    private final DomainEventChannel publisher = mock(DomainEventChannel.class);
    private final BookingRepository bookingRepository = mock(BookingRepository.class);

    private final ApartmentAppService apartmentAppService = new ApartmentAppService(apartmentRepository, publisher, bookingRepository);

    @Test
    void should_add_new_apartment() {
        ArgumentCaptor<Apartment> captor = ArgumentCaptor.forClass(Apartment.class);
        apartmentAppService.add(OWNER_ID, STREET, POSTAL_CODE,HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY,DESCRIPTION, ROOMS_DEFINITION);

        BDDMockito.then(apartmentRepository).should().save(captor.capture());
        ApartmentAssertion.assertThat(captor.getValue())
                .hasOwnerIdEqualsTo(OWNER_ID)
                .hasQuantityRoomsEqualsTo(2)
                .hasDescriptionEqualsTo(DESCRIPTION)
                .hasAddressEqualsTo(STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY);
    }

    @Test
    void given_apartment_when_apartment_book_event_should_be_save_booking() {
        var apartment = ApartmentFactory.create(OWNER_ID,STREET,POSTAL_CODE, HOUSE_NUMBER,APARTMENT_NUMBER,CITY,COUNTRY,DESCRIPTION,ROOMS_DEFINITION);
        ArgumentCaptor<Booking> captor = ArgumentCaptor.forClass(Booking.class);
        given(apartmentRepository.findByUuid(anyString())).willReturn(apartment);

        apartmentAppService.book(UUID.randomUUID().toString(),TENANT_ID,START,END);
        then(bookingRepository).should().save(captor.capture());

        Assertions.assertThat(captor.getValue())
                .hasFieldOrPropertyWithValue("tenantId", TENANT_ID);
    }

}
