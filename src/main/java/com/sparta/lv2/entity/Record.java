package com.sparta.lv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Records")
@Getter
@Setter
@NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;


    @Column(name = "bookId", nullable = false, length = 100)
    private Long bookId;


    @Column(name = "userId", nullable = false, length = 100)
    private Long userId;

    @Column(name = "borrowDate", length = 100)
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;

    @Column(name = "returnDate", length = 100)
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Column(name = "borrowStatus", nullable = false, length = 10)
    private int borrowStatus; // 0: 대출 가능, 1: 대출 중

    public Record(Book book, User user, Date borrowDate) {
        this.bookId = book.getBookId();
        this.userId = user.getUserId();
        this.borrowDate = borrowDate;
        this.borrowStatus = 0; // 초기값은 대출 가능
    }
}
