package pl.dkiszka.rentalapplication.app.apartmentbookinghistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentBooked;
import pl.dkiszka.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistory;
import pl.dkiszka.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistoryRepository;
import pl.dkiszka.rentalapplication.domain.apartmentbookinghistory.BookingPeriod;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Service
@RequiredArgsConstructor
public class ApartmentBookingHistoryAppService {

    private final ApartmentBookingHistoryRepository apartmentBookingHistoryRepository;


    public void consume(ApartmentBooked apartmentBooked) {

        var apartmentBookingHistory = apartmentBookingHistoryRepository.findByApartmentId(apartmentBooked.getApartmentId())
                .orElse(new ApartmentBookingHistory(apartmentBooked.getApartmentId()));

        var bookingPeriod = new BookingPeriod(apartmentBooked.getPeriodStart(), apartmentBooked.getPeriodEnd());

        apartmentBookingHistory.addBookingStart(apartmentBooked.getEventCreationDateTime(), apartmentBooked.getOwnerId(), apartmentBooked.getTenantId(), bookingPeriod);
        apartmentBookingHistoryRepository.save(apartmentBookingHistory);
    }

}
