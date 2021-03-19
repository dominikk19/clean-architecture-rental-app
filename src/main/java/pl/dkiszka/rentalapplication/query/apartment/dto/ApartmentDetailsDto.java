package pl.dkiszka.rentalapplication.query.apartment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
@Getter
public class ApartmentDetailsDto {
    private final ApartmentReadModelDto apartment;
    private final ApartmentBookingHistoryReadModelDto bookingHistory;
}
