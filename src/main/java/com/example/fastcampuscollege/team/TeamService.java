package com.example.fastcampuscollege.team;

import com.example.fastcampuscollege.global.EntityNotFoundException;
import com.example.fastcampuscollege.global.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Team createTeam(TeamRegistrationRequest dto) {
        return teamRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public Page<Team> findPage(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Team findById(Long id) {
        return teamRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Team not found", ErrorCode.INVALID_INPUT_VALUE));
    }

    @Transactional
    public Team updateTeam(Long id, TeamModificationRequest updatedTeam) {
        Team team = teamRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Team not found", ErrorCode.INVALID_INPUT_VALUE));

        team.update(
            updatedTeam.getName(), updatedTeam.getLocation()
        );

        return teamRepository.save(team);
    }

    @Transactional
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}