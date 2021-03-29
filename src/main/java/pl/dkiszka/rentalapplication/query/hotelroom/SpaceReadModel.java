package pl.dkiszka.rentalapplication.query.hotelroom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
//@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class SpaceReadModel {
    private String name;
    private Double value;
}
