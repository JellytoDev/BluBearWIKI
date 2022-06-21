package com.example.blubearwiki.dto.doc;

import com.example.blubearwiki.domain.doc.DocStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class DocSaveRequestDto {
    Long docId;
    Long docCategoryId;
    String title;
    String content;
}
