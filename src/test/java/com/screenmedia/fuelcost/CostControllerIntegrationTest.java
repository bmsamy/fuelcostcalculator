package com.screenmedia.fuelcost;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CostControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindJourneyCost() throws Exception {
        this.mockMvc.perform(get("/fuel/cost/15-09-2003/ulsp/25/100").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalJourneyCost", is(11.54)));
    }

    @Test
    public void testInvalidRequestFindJourneyCost() throws Exception {
        this.mockMvc.perform(get("/fuel/cost/2003/ulsp/25/100").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Failed to parse travel date : 2003")));
    }
}