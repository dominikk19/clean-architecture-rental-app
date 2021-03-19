package pl.dkiszka.rentalapplication.domain.hotelroom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class SquareMeter {
    private Double value;

    SquareMeter(Double value) {
        this.value = value;
    }
}
