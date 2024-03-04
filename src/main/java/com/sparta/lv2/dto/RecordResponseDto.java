package com.sparta.lv2.dto;

import com.sparta.lv2.entity.Book;
import com.sparta.lv2.entity.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class RecordResponseDto {
    private Long recordId;
    private Long bookId;
    private Long userId;
    private Date borrowDate;
    private Date returnDate;
    private int borrowStatus;

    public RecordResponseDto(Long recordId, Long bookId, Long userId, Date borrowDate, Date returnDate, int borrowStatus) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.borrowStatus = borrowStatus;
    }

    public RecordResponseDto(Record record) {
        this.recordId = record.getRecordId();
        this.bookId = record.getBookId();
        this.userId = record.getUserId();
        this.borrowDate = record.getBorrowDate();
        this.returnDate = record.getReturnDate();
        this.borrowStatus = record.getBorrowStatus();
    }
}