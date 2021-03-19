package pl.dkiszka.rentalapplication.domain.apartment;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
public interface ApartmentRepository {
    Apartment save(Apartment apartment);
}
