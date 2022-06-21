package com.example.blubearwiki.dto.doc;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocCreateRequestDto {
    Long docCategoryId;
    Long wikiId;
}
