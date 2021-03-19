package pl.dkiszka.rentalapplication.adapters.persistence.jpa.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
class JpaApartmentRepository implements ApartmentRepository {
    private final SpringJpaApartmentRepository springJpaApartmentRepository;

    @Override
    public Apartment save(Apartment apartment) {
        return springJpaApartmentRepository.save(apartment);
    }
}

interface SpringJpaApartmentRepository extends Repository<Apartment, Long> {
    Apartment save(Apartment apartment);
}

