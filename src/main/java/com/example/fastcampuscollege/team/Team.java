package com.example.fastcampuscollege.team;

import com.example.fastcampuscollege.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "team")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "founded_date", nullable = false)
    private LocalDate foundedDate;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(
        String name,
        String location,
        LocalDate foundedDate
    ) {
        Assert.hasLength(name, "name 값은 필수 값입니다.");
        Assert.hasLength(location, "location 값은 필수 값입니다.");
        Assert.notNull(foundedDate, "foundedDate 값은 필수 값입니다.");

        this.name = name;
        this.location = location;
        this.foundedDate = foundedDate;
    }

    public void update(
        final String name,
        final String location
    ) {
        this.name = name;
        this.location = location;
    }
}
