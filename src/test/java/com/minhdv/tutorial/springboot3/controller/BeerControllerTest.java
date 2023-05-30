package com.minhdv.tutorial.springboot3.controller;

import com.minhdv.tutorial.springboot3.model.Beer;
import com.minhdv.tutorial.springboot3.services.BeerService;
import com.minhdv.tutorial.springboot3.services.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * CREATE BY MinhDV
 */
@AutoConfigureMockMvc
@WebMvcTest(BeerController.class)
public class BeerControllerTest {
    //    @Autowired
//    BeerController beerController;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BeerService beerService;

    private BeerServiceImpl beerServiceImpl = new BeerServiceImpl();

    @Test
    void getBeerById() throws Exception {
        beerServiceImpl.init();
        Beer test = beerServiceImpl.listBeers().get(0);
        given(beerService.getBeerById(any(UUID.class))).willReturn(test);

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;
    }

}
