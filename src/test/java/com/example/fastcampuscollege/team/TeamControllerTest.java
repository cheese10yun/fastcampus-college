package com.example.fastcampuscollege.team;

import com.example.fastcampuscollege.TestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TeamControllerTest extends TestSupport {

    @Test
    public void team_page_test() throws Exception {
        mockMvc.perform(
                get("/api/teams/1")
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.name").isNotEmpty())
            .andExpect(jsonPath("$.location").isNotEmpty())
            .andExpect(jsonPath("$.foundedDate").isNotEmpty())
            ;
    }

    @Test
    public void team_create() throws Exception {
        mockMvc.perform(
                post("/api/teams")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(readJson("/team-api/TeamRegistrationRequest.json"))
            )
            .andExpect(status().isOk())
        ;
    }
}