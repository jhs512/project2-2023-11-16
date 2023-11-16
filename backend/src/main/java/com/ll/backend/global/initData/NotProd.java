package com.ll.backend.global.initData;

import com.ll.backend.domain.article.article.service.ArticleService;
import com.ll.backend.domain.member.member.entity.Member;
import com.ll.backend.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {
    @Bean
    ApplicationRunner initNotProd(
            MemberService memberService,
            ArticleService articleService
    ) {
        return args -> {
            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();

            articleService.write(member1, "제목1", "내용1");
            articleService.write(member1, "제목2", "내용2");
            articleService.write(member1, "제목3", "내용3");

            articleService.write(member2, "제목4", "내용4");
            articleService.write(member2, "제목5", "내용5");
            articleService.write(member2, "제목6", "내용6");
        };
    }
}
