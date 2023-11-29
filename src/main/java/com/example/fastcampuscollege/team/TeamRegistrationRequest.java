package com.example.fastcampuscollege.team;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TeamRegistrationRequest {
    @NotEmpty
    @NotNull
    private final String name;

    @NotEmpty
    @NotNull
    private final String location;

    @NotNull
    private final LocalDate foundedDate;

    public Team toEntity() {

        return Team.builder()
                .name(name)
                .location(location)
                .foundedDate(foundedDate)
                .build();
    }
}