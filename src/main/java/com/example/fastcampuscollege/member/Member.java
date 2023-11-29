package com.example.fastcampuscollege.member;

import com.example.fastcampuscollege.team.Team;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "joined_date", nullable = false)
    private LocalDate joinedDate;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 매핑, Member 입장에서 Team은 하나이며, 지연로딩 사용
    @JoinColumn(name = "team_id") // 외래키는 team_id로 매핑
    private Team team;

    @Builder
    public Member(String firstName, String lastName, String address, Team team) {
        Assert.hasLength(firstName, "firstName 값은 필수 값입니다.");
        Assert.hasLength(lastName, "address 값은 필수 값입니다.");
        Assert.hasLength(address, "address 값은 필수 값입니다.");
        Assert.notNull(team, "team 값은 필수 값입니다.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = LocalDate.now();
        this.team = team;
    }

    public void update(String firstName, String lastName, String address, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = LocalDate.now();
        this.team = team;
    }
}
