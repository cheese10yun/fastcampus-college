package com.example.fastcampuscollege.team;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public TeamResponse createTeam(@RequestBody @Valid TeamRegistrationRequest team) {
        return new TeamResponse(teamService.createTeam(team));
    }

    @GetMapping
    public Page<TeamResponse> getAllTeams(@PageableDefault Pageable pageable) {
        return teamService.findPage(pageable).map(TeamResponse::new);
    }

    @GetMapping("/{id}")
    public TeamResponse getTeamById(@PathVariable Long id) {
        return new TeamResponse(teamService.findById(id));
    }

    @PutMapping("/{id}")
    public void updateTeam(@PathVariable Long id, @RequestBody @Valid TeamModificationRequest dto) {
        teamService.updateTeam(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}