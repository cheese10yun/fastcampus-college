package com.example.fastcampuscollege.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberModificationRequest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final LocalDate joinedDate;
    private final Long teamId;
}
