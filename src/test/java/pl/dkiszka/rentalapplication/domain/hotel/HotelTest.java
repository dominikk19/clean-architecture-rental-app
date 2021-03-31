package pl.dkiszka.rentalapplication.domain.hotel;

import org.junit.jupiter.api.Test;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
class HotelTest {

    private static final String HOTEL_NAME = "Blue Hotel";
    private static final String STREET = "Johny Rambo";
    private static final String POSTAL_CODE = "01-123";
    private static final String BUILDING_NUMBER = "12";
    private static final String CITY = "Warsaw";
    private static final String COUNTRY = "Poland";

    @Test
    void should_create_Hotel_room_with_all_from_factory() {
        var hotelDto = new HotelDto(HOTEL_NAME, STREET, POSTAL_CODE, BUILDING_NUMBER, CITY, COUNTRY);
        var actual = HotelFactory.create(hotelDto);
        HotelAssertion.assertThat(actual)
                .hasContainUuidCompatibleWithPattern()
                .hasNameEqualsTo(HOTEL_NAME)
                .hasCityEqualsTo(CITY)
                .hasStreetEqualsTo(STREET);
    }

}
