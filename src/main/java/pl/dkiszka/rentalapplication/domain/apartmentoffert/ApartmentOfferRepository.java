package pl.dkiszka.rentalapplication.domain.apartmentoffert;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
public interface ApartmentOfferRepository {
    ApartmentOffer save(ApartmentOffer apartmentOffer);
}
