package com.example.fastcampuscollege.member;

import com.example.fastcampuscollege.team.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberRegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final LocalDate joinedDate;
    private final Long teamId;

    public Member toEntity(Team team) {
        return Member.builder()
            .firstName(firstName)
            .lastName(lastName)
            .address(address)
            .team(team)
            .build();
    }
}
