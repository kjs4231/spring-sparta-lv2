package com.sparta.lv2.dto;

import com.sparta.lv2.entity.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordResponseDto {
    private Long recordId;
    private Long bookId;
    private String bookTitle;
    private String bookWriter;
    private Long userId;
    private String userName;
    private String userPhoneNum;
    private String borrowDate;
    private String returnDate;
    private int borrowStatus;

    public RecordResponseDto(Record record, String bookTitle, String bookWriter, String userName, String userPhoneNum) {
        this.recordId = record.getRecordId();
        this.bookId = record.getBookId();
        this.bookTitle = bookTitle;
        this.bookWriter = bookWriter;
        this.userId = record.getUserId();
        this.userName = userName;
        this.userPhoneNum = userPhoneNum;
        this.borrowDate = record.getBorrowDate().toString(); // 예시로 toString()을 사용했는데 실제로는 포맷팅을 해주는 것이 좋습니다.
        this.returnDate = record.getReturnDate() != null ? record.getReturnDate().toString() : null; // 반환일이 없으면 null
        this.borrowStatus = record.getBorrowStatus();
    }
}
