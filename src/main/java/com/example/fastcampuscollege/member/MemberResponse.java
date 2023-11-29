package com.example.fastcampuscollege.member;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final LocalDate joinedDate;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.address = member.getAddress();
        this.joinedDate = member.getJoinedDate();
    }
}
