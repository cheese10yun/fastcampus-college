package com.example.fastcampuscollege.team;

import com.example.fastcampuscollege.member.Member;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class TeamResponse {
    private final Long id;
    private final String name;
    private final String location;
    private final LocalDate foundedDate;

    public TeamResponse(final Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.location = team.getLocation();
        this.foundedDate = team.getFoundedDate();
    }
}
