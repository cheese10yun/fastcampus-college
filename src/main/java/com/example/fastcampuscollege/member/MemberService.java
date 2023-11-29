package com.example.fastcampuscollege.member;

import com.example.fastcampuscollege.team.Team;
import com.example.fastcampuscollege.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamService teamService;

    @Transactional
    public Member createMember(MemberRegistrationRequest dto) {
        final Team team = teamService.findById(dto.getTeamId());
        final Member entity = dto.toEntity(team);
        return memberRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public Page<Member> findPage(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Transactional
    public void updateMember(Long id, MemberModificationRequest dto) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Member not found"));

        final Team team = teamService.findById(dto.getTeamId());

        member.update(
            dto.getFirstName(),
            dto.getLastName(),
            dto.getAddress(),
            team
        );
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}