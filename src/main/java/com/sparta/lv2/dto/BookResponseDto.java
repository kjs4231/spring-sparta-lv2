package com.sparta.lv2.dto;

import com.sparta.lv2.entity.Book;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private int borrowStatus;
    private LocalDateTime date;

    public BookResponseDto(Book memo) {
        this.bookId = memo.getBookId();
        this.title = memo.getTitle();
        this.writer = memo.getWriter();
        this.language = memo.getLanguage();
        this.publisher = memo.getPublisher();
        this.borrowStatus = memo.getBorrowStatus();
        this.date = memo.getDate();
    }
}