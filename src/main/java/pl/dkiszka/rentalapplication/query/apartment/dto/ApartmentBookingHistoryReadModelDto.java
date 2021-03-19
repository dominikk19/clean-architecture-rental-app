package pl.dkiszka.rentalapplication.query.apartment.dto;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface ApartmentBookingHistoryReadModelDto {
    String getApartmentId();

    List<ApartmentBookingReadModelDto> getBookings();
}
