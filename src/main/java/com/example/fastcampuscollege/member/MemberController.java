package com.example.fastcampuscollege.member;

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
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberResponse createMember(@RequestBody @Valid MemberRegistrationRequest dto) {
        return new MemberResponse(memberService.createMember(dto));
    }

    @GetMapping
    public Page<MemberResponse> getAllMembers(@PageableDefault Pageable pageable) {
        return memberService.findPage(pageable).map(MemberResponse::new);
    }

    @GetMapping("/{id}")
    public MemberResponse getMemberById(@PathVariable Long id) {
        return new MemberResponse(memberService.findById(id));
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody @Valid MemberModificationRequest memberRequest) {
        memberService.updateMember(id, memberRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}