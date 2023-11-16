package com.ll.backend.global.initData;

import com.ll.backend.domain.article.article.service.ArticleService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {
    @Bean
    ApplicationRunner initNotProd(
            ArticleService articleService
    ) {
        return args -> {
            articleService.write("제목1", "내용1");
            articleService.write("제목2", "내용2");
            articleService.write("제목3", "내용3");
        };
    }
}
