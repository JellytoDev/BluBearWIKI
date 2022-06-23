package com.example.blubearwiki.dto.doc;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocEditInfoDto {
    Long wikiId;
    Long docId;
    Long docCategoryId;
}
