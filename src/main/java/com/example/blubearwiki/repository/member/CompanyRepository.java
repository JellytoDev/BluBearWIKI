package com.example.blubearwiki.repository.member;

import com.example.blubearwiki.domain.member.Company;
import com.example.blubearwiki.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
