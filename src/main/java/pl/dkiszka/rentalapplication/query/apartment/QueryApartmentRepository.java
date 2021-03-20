package pl.dkiszka.rentalapplication.query.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.query.apartment.dto.ApartmentBookingHistoryReadModelDto;
import pl.dkiszka.rentalapplication.query.apartment.dto.ApartmentDetailsDto;
import pl.dkiszka.rentalapplication.query.apartment.dto.ApartmentReadModelDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public class QueryApartmentRepository {
    private final SpringQueryApartmentRepository springQueryApartmentRepository;
    private final SpringQueryApartmentBookingHistoryRepository springQueryApartmentBookingHistoryRepository;

    public List<ApartmentReadModelDto> findAll() {
        return springQueryApartmentRepository.findAllBy();
    }

    public ApartmentDetailsDto findByUuid(String uuid) {
        var apartmentReadModel = springQueryApartmentRepository.findByUuid(uuid)
                .orElseThrow();
        var apartmentBookingHistoryReadModel = springQueryApartmentBookingHistoryRepository.findByApartmentId(uuid)
                .orElseThrow();
        return new ApartmentDetailsDto(apartmentReadModel, apartmentBookingHistoryReadModel);
    }
}

interface SpringQueryApartmentRepository extends Repository<ApartmentReadModel, String> {
    List<ApartmentReadModelDto> findAllBy();

    Optional<ApartmentReadModelDto> findByUuid(String uuid);
}

interface SpringQueryApartmentBookingHistoryRepository extends Repository<ApartmentBookingHistoryReadModel, String> {
    Optional<ApartmentBookingHistoryReadModelDto> findByApartmentId(String apartmentId);
}
