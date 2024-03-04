package com.sparta.lv2.repository;

import com.sparta.lv2.entity.Book;
import com.sparta.lv2.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByBookIdAndReturnDateIsNull(Long bookId);
    Record findByBorrowStatusAndUserId(int borrowStatus, Long userId);
    Record findByBorrowStatusAndBookId(int borrowStatus, Long bookId);
}
