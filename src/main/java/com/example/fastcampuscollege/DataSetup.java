package com.example.fastcampuscollege;

import com.example.fastcampuscollege.member.Member;
import com.example.fastcampuscollege.member.MemberRepository;
import com.example.fastcampuscollege.team.Team;
import com.example.fastcampuscollege.team.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class DataSetup implements ApplicationRunner {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        List<Team> teams = new ArrayList<>();


        teams.add(
            Team.builder()
                .name("name1")
                .location("location2")
                .foundedDate(LocalDate.of(2023, 11, 12))
                .build()
        );

        teams.add(
            Team.builder()
                .name("name2")
                .location("location2")
                .foundedDate(LocalDate.of(2023, 11, 12))
                .build()
        );

        teams.add(
            Team.builder()
                .name("name3")
                .location("location3")
                .foundedDate(LocalDate.of(2023, 11, 12))
                .build()
        );

        teamRepository.saveAll(teams);

        List<Member> members = new ArrayList<>();

        members.add(
            Member.builder()
                .firstName("firstName1")
                .lastName("lastName1")
                .address("address1")
                .team(teams.get(0))
                .build()
        );

        members.add(
            Member.builder()
                .firstName("firstName2")
                .lastName("lastName2")
                .address("address2")
                .team(teams.get(1))
                .build()
        );

        members.add(
            Member.builder()
                .firstName("firstName3")
                .lastName("lastName3")
                .address("address3")
                .team(teams.get(2))
                .build()
        );

        memberRepository.saveAll(members);

    }
}
