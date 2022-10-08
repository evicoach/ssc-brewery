package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class BeerRestControllerIT extends BaseIT {

    @Test
    void deleteBeer() throws Exception{
        mockMvc.perform(delete("/api/v1/beer/97df8c39-90c4-4ae0-b663-453e8e19c311")
                        .header("Api-Key", "spring").header("Api-secret", "guru"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeers() throws Exception {
        mockMvc.perform(get("/api/v1/veer/"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeersById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/97df8c39-90c4-4ae0-b663-453e8e19c311"))
                .andExpect(status().isOk());
    }
}
