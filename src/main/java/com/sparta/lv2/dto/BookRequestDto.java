package com.sparta.lv2.dto;

import lombok.Getter;

@Getter
public class BookRequestDto {
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private int borrowStatus;
}