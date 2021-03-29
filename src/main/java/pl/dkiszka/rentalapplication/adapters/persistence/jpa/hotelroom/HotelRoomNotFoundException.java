package pl.dkiszka.rentalapplication.adapters.persistence.jpa.hotelroom;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
class HotelRoomNotFoundException extends RuntimeException {
    HotelRoomNotFoundException(String message) {
        super(message);
    }
}
