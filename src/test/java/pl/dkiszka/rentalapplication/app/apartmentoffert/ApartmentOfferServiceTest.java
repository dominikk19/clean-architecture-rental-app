package pl.dkiszka.rentalapplication.app.apartmentoffert;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.dkiszka.rentalapplication.adapters.persistence.jpa.apartment.ApartmentNotFoundException;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentDto;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentFactory;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentAvailabilityException;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentOffer;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentOfferRepository;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.NotAllowedValueException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
class ApartmentOfferServiceTest {

    private static final String OWNER_ID = UUID.randomUUID().toString();
    private static final String STREET = "Jerozolimskie";
    private static final String POSTAL_CODE = "02-123";
    private static final String HOUSE_NUMBER = "12";
    private static final String APARTMENT_NUMBER = "33";
    private static final String CITY = "Warsaw";
    private static final String COUNTRY = "Poland";
    private static final String DESCRIPTION = "some text";
    private static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of("Toilet", 10.0, "Bedroom", 30.0);
    private static final String APARTMENT_ID = UUID.randomUUID().toString();
    private static final BigDecimal PRICE = BigDecimal.valueOf(123);
    private static final LocalDate START = LocalDate.of(2020, 10, 11);
    private static final LocalDate END = LocalDate.of(2020, 10, 20);
    private final ApartmentDto apartmentDto = new ApartmentDto(OWNER_ID, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY, DESCRIPTION, ROOMS_DEFINITION);
    private final Apartment apartment = ApartmentFactory.create(apartmentDto);

    private final ApartmentOfferRepository apartmentOfferRepository = mock(ApartmentOfferRepository.class);
    private final ApartmentRepository apartmentRepository = mock(ApartmentRepository.class);
    private final ApartmentOfferService service = new ApartmentOfferService(apartmentOfferRepository, apartmentRepository);


    @Test
    void should_create_apartment_offer_for_existing_apartment() {
        var captor = ArgumentCaptor.forClass(ApartmentOffer.class);
        var apartmentOffer = new ApartmentOfferDto(APARTMENT_ID, PRICE, START, END);

        when(apartmentRepository.findByUuid(APARTMENT_ID)).thenReturn(apartment);

        service.add(apartmentOffer);

        then(apartmentOfferRepository).should().save(captor.capture());
        ApartmentOfferAssertion.assertThat(captor.getValue())
                .hasApartmentUuidEqualTo(APARTMENT_ID)
                .hasPriceEqualTo(PRICE)
                .hasAvailabilityEqualTo(START, END);
    }

    @Test
    void should_create_apartment_offer_with_zero_price() {
        when(apartmentRepository.findByUuid(APARTMENT_ID)).thenReturn(apartment);
        var captor = ArgumentCaptor.forClass(ApartmentOffer.class);

        service.add(new ApartmentOfferDto(APARTMENT_ID, BigDecimal.ZERO, START, END));

        then(apartmentOfferRepository).should().save(captor.capture());
        ApartmentOfferAssertion.assertThat(captor.getValue())
                .hasApartmentUuidEqualTo(APARTMENT_ID)
                .hasPriceEqualTo(BigDecimal.ZERO)
                .hasAvailabilityEqualTo(START, END);
    }


    @Test
    void should_recognize_price_lower_than_zero() {
        when(apartmentRepository.findByUuid(APARTMENT_ID)).thenReturn(apartment);
        var dto = new ApartmentOfferDto(APARTMENT_ID, BigDecimal.valueOf(-13), START, END);

        var actual = assertThrows(NotAllowedValueException.class, () -> service.add(dto));

        assertThat(actual).hasMessage("Price -13 is lower than zero.");
    }

    @Test
    void should_recognize_than_start_is_after_end() {
        when(apartmentRepository.findByUuid(APARTMENT_ID)).thenReturn(apartment);
        var dto = new ApartmentOfferDto(APARTMENT_ID, PRICE, END, START);

        var actual = assertThrows(ApartmentAvailabilityException.class, () -> service.add(dto));

        assertThat(actual).hasMessage("Start date: 2020-10-20 is after of end: 2020-10-11");
    }
}
