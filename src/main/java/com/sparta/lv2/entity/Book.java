package com.sparta.lv2.entity;

import com.sparta.lv2.dto.BookRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "Books") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Book extends BookTime {
    public static final int BORROWED = 1;
    public static final int AVAILABLE = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "writer", nullable = false, length = 100)
    private String writer;
    @Column(name = "language", nullable = false, length = 100)
    private String language;
    @Column(name = "publisher", nullable = false, length = 100)
    private String publisher;
    @Column(name = "borrowStatus", nullable = false)
    private int borrowStatus; // BORROWED=대출중, AVAILABLE=대출가능

    public Book(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
        this.borrowStatus = requestDto.getBorrowStatus();
    }

    public void update(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
        this.borrowStatus = requestDto.getBorrowStatus();
    }
}