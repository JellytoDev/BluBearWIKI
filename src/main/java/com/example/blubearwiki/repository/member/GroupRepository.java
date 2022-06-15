package com.example.blubearwiki.repository.member;

import com.example.blubearwiki.domain.member.Company;
import com.example.blubearwiki.domain.member.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

}
