package pl.dkiszka.rentalapplication.domain.hotelRoom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Space {
    private final String name;
    private final SquareMeter squareMeter;
}
