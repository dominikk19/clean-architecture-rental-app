package pl.dkiszka.rentalapplication.query.apartment;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
class ApartmentBookingHistoryReadModel {
    @Id
    private String apartmentId;

    @ElementCollection
    private List<ApartmentBookingReadModel> bookings = Lists.newArrayList();
}
