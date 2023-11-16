package com.ll.backend.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;

    public static <T> RsData of(String resultCode, String msg, T data) {
        return new RsData(resultCode, msg, data);
    }
}