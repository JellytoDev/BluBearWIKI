package com.example.blubearwiki.dto.doc;

import com.example.blubearwiki.domain.doc.DocStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocSetRequestDto {
    Long docId;
    Long docCategoryId;
    DocStatus status;
}
