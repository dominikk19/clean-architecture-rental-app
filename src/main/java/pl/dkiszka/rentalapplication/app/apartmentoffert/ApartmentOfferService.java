package pl.dkiszka.rentalapplication.app.apartmentoffert;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentAvailability;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentOffer;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentOfferRepository;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.Money;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ApartmentOfferService {
    private final ApartmentOfferRepository apartmentOfferRepository;
    private final ApartmentRepository apartmentRepository;

    public void add(ApartmentOfferDto apartmentOfferDto) {
        apartmentRepository.findByUuid(apartmentOfferDto.getApartmentUuid());

        var apartmentOffer = ApartmentOffer.builder()
                .apartmentUuid(apartmentOfferDto.getApartmentUuid())
                .money(Money.of(apartmentOfferDto.getPrice()))
                .availability(ApartmentAvailability.of(apartmentOfferDto.getStart(), apartmentOfferDto.getEnd()))
                .build();

        apartmentOfferRepository.save(apartmentOffer);
    }
}
