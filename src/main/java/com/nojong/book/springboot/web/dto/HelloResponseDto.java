package com.nojong.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/*
*   @RequiredArgsConstructor
*   - final이 포함된 생성자를 생성해준다.
*   - final이 없는 필드는 생성자에 포함하지 않음.
* */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
