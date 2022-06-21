package com.example.blubearwiki.dto.doc;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocCategoryResponseDto {
    Long docCategoryId;
    String name;
}
