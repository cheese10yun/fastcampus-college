package com.example.fastcampuscollege.member;

import com.example.fastcampuscollege.TestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberControllerTest extends TestSupport {

    @Test
    public void member_page_test() throws Exception {
        mockMvc.perform(
                get("/api/members/1")
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.firstName").isNotEmpty());
    }

    @Test
    public void member_create() throws Exception {
        mockMvc.perform(
                post("/api/members")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(readJson("/member-api/MemberRegistrationRequest.json"))
            )
            .andExpect(status().isOk())
        ;
    }

}