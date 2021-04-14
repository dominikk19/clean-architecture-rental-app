package pl.dkiszka.rentalapplication.adapters.rest.api.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import pl.dkiszka.rentalapplication.domain.hotel.HotelDto;
import pl.dkiszka.rentalapplication.domain.hotel.HotelRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 14.04.2021
 */
@SpringBootTest
@AutoConfigureMockMvc
@Tag("SystemTest")
@Import(InMemoryDatabaseHotelTestConfiguration.class)
class HotelRestControllerSystemTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void given_hotel_booking_dto_when_request_post_on_hotel_room_then_should_be_save_hotel() throws Exception {
        var hotelDto = new HotelDto("New Hotel", "Płaska", "02-322", "13", "Warsaw", "Poland");
        postRequest("/hotel", hotelDto, status().isCreated());
    }

    private ResultActions postRequest(String url, Object content, ResultMatcher resultMatcher) throws Exception {
        return this.mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(content)))
                .andExpect(resultMatcher);
    }

}
