package com.ll.backend.domain.article.article.service;

import com.ll.backend.domain.article.article.entity.Article;
import com.ll.backend.domain.article.article.repository.ArticleRepository;
import com.ll.backend.domain.member.member.entity.Member;
import com.ll.backend.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public RsData<Article> write(Member author, String title, String body) {
        Article article = Article.builder()
                .author(author)
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("S-1", "성공", article);
    }
}
