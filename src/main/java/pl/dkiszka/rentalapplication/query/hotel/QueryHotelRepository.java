package pl.dkiszka.rentalapplication.query.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import pl.dkiszka.rentalapplication.query.hotel.dto.HotelReadModelDto;

import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class QueryHotelRepository {
    private final SpringJpaQueryHotelRepository springJpaQueryHotelRepository;

    public List<HotelReadModelDto> findAll() {
        return springJpaQueryHotelRepository.findAllBy();
    }
}

interface SpringJpaQueryHotelRepository extends Repository<HotelReadModel, String> {
    List<HotelReadModelDto> findAllBy();

}
