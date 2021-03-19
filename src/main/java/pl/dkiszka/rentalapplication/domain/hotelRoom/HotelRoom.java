package pl.dkiszka.rentalapplication.domain.hotelRoom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class HotelRoom {
    private String uuid;
    private final String hotelId;
    private final int number;
    private final List<Space> spaces;
    private final String description;
}
