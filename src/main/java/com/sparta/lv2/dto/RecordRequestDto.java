package com.sparta.lv2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordRequestDto {
    private Long bookId;
    private Long userId; // 대출 회원의 아이디 등 필요한 정보 추가
}
