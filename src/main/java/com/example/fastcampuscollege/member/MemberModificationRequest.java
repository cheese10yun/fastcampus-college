package com.example.fastcampuscollege.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberModificationRequest {
    @NotEmpty
    private final String firstName;

    @NotEmpty
    private final String lastName;

    @NotEmpty
    private final String address;

    @NotNull
    private final LocalDate joinedDate;

    @NotNull
    private final Long teamId;
}
