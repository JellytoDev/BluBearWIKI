package com.example.blubearwiki.repository.doc;

import com.example.blubearwiki.domain.doc.Doc;
import com.example.blubearwiki.domain.doc.DocLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocLogRepository extends JpaRepository<DocLog, Long> {

}
