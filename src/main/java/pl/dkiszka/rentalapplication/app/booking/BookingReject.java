package pl.dkiszka.rentalapplication.app.booking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
@Getter
public class BookingReject {
    private final String uuid;
}
