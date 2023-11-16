package com.ll.backend.domain.member.member.dto;

import com.ll.backend.domain.member.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class MemberDto {
    private final long id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final String username;
    private final String password;

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .createDate(member.getCreateDate())
                .modifyDate(member.getModifyDate())
                .username(member.getUsername())
                .password(member.getPassword())
                .build();
    }
}

