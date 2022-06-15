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
public interface DocCategoryRepository extends JpaRepository<DocCategory, Long> {
    List<DocCategory> findBySeqBetween(Integer start, Integer end);

    @Query(value = "select dc from DocCategory dc where dc.name = :name")
    DocCategory findByNameWhere(String name);

    @Query(value = "select dc from DocCategory dc where dc.name in :names")
    DocCategory findByNames(ArrayList<String> names);

    @Override
    Optional<DocCategory> findById(Long aLong);
}
