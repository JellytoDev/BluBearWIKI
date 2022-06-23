package com.example.blubearwiki.dto.doc;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocCategoryDto {
    Long id;
    String name;

    public DocCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
