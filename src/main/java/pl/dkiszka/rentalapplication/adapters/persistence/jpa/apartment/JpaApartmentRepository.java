package pl.dkiszka.rentalapplication.adapters.persistence.jpa.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.domain.apartment.Apartment;
import pl.dkiszka.rentalapplication.domain.apartment.ApartmentRepository;

import java.util.Optional;

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

    @Override
    public Apartment findByUuid(String uuid) {
        return springJpaApartmentRepository.findByUuid(uuid)
                .orElseThrow(() -> new ApartmentNotFoundException(String.format("Apartment uuid: %s not exist", uuid)));
    }
}

interface SpringJpaApartmentRepository extends Repository<Apartment, String> {
    Apartment save(Apartment apartment);

    Optional<Apartment> findByUuid(String uuid);
}

