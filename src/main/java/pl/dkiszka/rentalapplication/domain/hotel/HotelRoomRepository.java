package pl.dkiszka.rentalapplication.domain.hotel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface HotelRoomRepository {
    HotelRoom save(HotelRoom hotelRoom);

    HotelRoom findByUuid(String uuid);
}
