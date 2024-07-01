package com.wcc.platform.controller;

import com.wcc.platform.domain.cms.pages.CollaboratorPage;
import com.wcc.platform.domain.cms.pages.TeamPage;
import com.wcc.platform.domain.platform.Member;
import com.wcc.platform.service.CmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cms/v1/")
@Tag(name = "APIs relevant About Us section")
public class AboutController {

    private final CmsService cmsService;

    @Autowired
    public AboutController(CmsService service) {
        this.cmsService = service;
    }

    @GetMapping("/team")
    @Operation(summary = "API to retrieve information about leadership team members")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TeamPage> getTeamPage() {
        return ResponseEntity.ok(cmsService.getTeam());
    }

    @GetMapping("/collaborators")
    @Operation(summary = "API to retrieve information about collaborators")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CollaboratorPage> getCollaboratorPage() {
        return ResponseEntity.ok(cmsService.getCollaborator());
    }

    @PutMapping("/member/")
    @Operation(summary = "API to submit member registration")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(cmsService.createMember(member));
    }
}
