package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class ApartmentBookingHistory {

    private final String apartmentId;
    private final List<ApartmentBooking> bookings = Lists.newArrayList();

    public void add(ApartmentBooking apartmentBooking) {
        bookings.add(apartmentBooking);
    }
}
