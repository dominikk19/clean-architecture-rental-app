package pl.dkiszka.rentalapplication.app.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dkiszka.rentalapplication.adapters.rest.api.apartment.ApartmentDto;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentFactory;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;
import pl.dkiszka.rentalapplication.domain.booking.BookingRepository;
import pl.dkiszka.rentalapplication.domain.booking.Period;

import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Service
@RequiredArgsConstructor
public class ApartmentAppService {
    private final ApartmentRepository apartmentRepository;
    private final DomainEventChannel eventChannel;
    private final BookingRepository bookingRepository;

    @SuppressWarnings("checkstyle:ParameterNumber")
    public void add(ApartmentDto apartmentDto) {
        var apartment = ApartmentFactory.create(apartmentDto);
        apartmentRepository.save(apartment);
    }

    public void book(String uuid, String tenantId, LocalDate start, LocalDate end) {
        var apartment = apartmentRepository.findByUuid(uuid);
        var booking = apartment.book(tenantId, new Period(start, end), eventChannel);
        bookingRepository.save(booking);
    }
}
