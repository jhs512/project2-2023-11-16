package com.ll.backend.domain.article.article.dto;

import com.ll.backend.domain.article.article.entity.Article;
import com.ll.backend.domain.member.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class ArticleDto {
    private final long id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final MemberDto author;
    private final String title;
    private final String body;

    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .createDate(article.getCreateDate())
                .modifyDate(article.getModifyDate())
                .author(MemberDto.of(article.getAuthor()))
                .title(article.getTitle())
                .body(article.getBody())
                .build();
    }
}

