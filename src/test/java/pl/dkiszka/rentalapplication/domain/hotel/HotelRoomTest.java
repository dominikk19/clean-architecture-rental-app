package pl.dkiszka.rentalapplication.domain.hotel;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
class HotelRoomTest {

    private static final String HOTEL_ID = "1234";
    private static final int ROOM_NUMBER = 12;
    private static final Map<String, Double> SPACES_DEFINITION = Map.of("RoomOne", 20.0, "RoomTwo", 20.0);
    private static final String DESCRIPTION = "some description";
    private final String TENANT_ID = UUID.randomUUID().toString();
    private final List<LocalDate> DAYS = List.of(LocalDate.of(2021, 3, 21), LocalDate.of(2021, 3, 30));


    private final HotelRoomEventsPublisher publisher = Mockito.mock(HotelRoomEventsPublisher.class);


    @Test
    void should_create_Hotel_room_with_all_from_factory() {
        var hotelRoomDto = new HotelRoomDto(HOTEL_ID, ROOM_NUMBER, SPACES_DEFINITION, DESCRIPTION);
        var actual = HotelRoomFactory.create(hotelRoomDto);

        HotelRoomAssertion.assertThat(actual)
                .hasContainUuidCompatibleWithPattern()
                .hasHotelIdEqualsTo(HOTEL_ID)
                .hasNumberEqualsTo(ROOM_NUMBER)
                .hasContainSpaces(SPACES_DEFINITION);
    }

    @Test
    void when_book_hotel_room_should_be_return_booking() {
        var hotelRoomDto = new HotelRoomDto(HOTEL_ID, ROOM_NUMBER, SPACES_DEFINITION, DESCRIPTION);
        var hotelRoom = HotelRoomFactory.create(hotelRoomDto);

        var actual = hotelRoom.book(TENANT_ID, DAYS, publisher);


        HotelRoomBookingAssertion.assertThat(actual)
                .hasContainUuidCompatibleWithPattern()
                .hasTenantIdEqualsTo(TENANT_ID)
                .hasContainsDays(DAYS);
    }
}
