package com.example.blubearwiki.dto.member;

import com.example.blubearwiki.domain.member.Company;
import com.example.blubearwiki.domain.member.Group;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private List<Group> groups;

    public void fromCompany(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.groups = company.getGroups();
    }
}
