package com.ll.backend.domain.article.article.controller;

import com.ll.backend.domain.article.article.dto.ArticleDto;
import com.ll.backend.domain.article.article.entity.Article;
import com.ll.backend.domain.article.article.service.ArticleService;
import com.ll.backend.global.rsData.RsData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticlesController {
    private final ArticleService articleService;

    @Getter
    public static class GetArticlesResponseBody {
        private List<ArticleDto> items;

        public GetArticlesResponseBody(List<Article> articles) {
            this.items = articles.stream().map(
                    article -> ArticleDto.of(article)
            ).toList();
        }
    }

    @GetMapping("")
    public ResponseEntity<RsData<GetArticlesResponseBody>> getArticles() {
        return ResponseEntity.ok(
                RsData.of("S-1", "성공", new GetArticlesResponseBody(articleService.findAll()))
        );
    }
}
