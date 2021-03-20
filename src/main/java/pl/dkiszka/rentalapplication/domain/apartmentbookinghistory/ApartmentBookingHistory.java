package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@Table(name = "APARTMENT_BOOKING_HISTORY")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApartmentBookingHistory {
    @Id
    private String apartmentId;

//    @ElementCollection
//    private final List<ApartmentBooking> bookings = Lists.newArrayList();

    public ApartmentBookingHistory(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public void add(ApartmentBooking apartmentBooking) {
       // bookings.add(apartmentBooking);
    }
}
