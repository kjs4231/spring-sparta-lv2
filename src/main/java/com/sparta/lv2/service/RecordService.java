package com.sparta.lv2.service;

import com.sparta.lv2.dto.RecordRequestDto;
import com.sparta.lv2.dto.RecordResponseDto;
import com.sparta.lv2.entity.Book;
import com.sparta.lv2.entity.Record;
import com.sparta.lv2.entity.User;
import com.sparta.lv2.repository.BookRepository;
import com.sparta.lv2.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final BookRepository bookRepository;

    public int returnBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("ID에 해당하는 도서를 찾지 못했습니다."));

        if (book.getBorrowStatus() == 0) {
            return 0;
        }

        Record record = recordRepository.findByBookIdAndReturnDateIsNull(bookId);

        if (record == null) {
            return 0;
        }

        book.setBorrowStatus(0);
        bookRepository.save(book);

        record.setReturnDate(new Date());
        recordRepository.save(record);
        return 1;
    }

    public List<RecordResponseDto> getAllBorrowHistory() {
        List<Record> borrowRecords = recordRepository.findAll();
        return borrowRecords.stream()
                .map(RecordResponseDto::new)
                .collect(Collectors.toList());
    }
}
