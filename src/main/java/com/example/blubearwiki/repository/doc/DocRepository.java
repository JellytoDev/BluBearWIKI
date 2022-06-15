package com.example.blubearwiki.repository.doc;

import com.example.blubearwiki.domain.doc.Doc;
import com.example.blubearwiki.domain.doc.DocCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface DocRepository extends JpaRepository<Doc, Long> {

}
