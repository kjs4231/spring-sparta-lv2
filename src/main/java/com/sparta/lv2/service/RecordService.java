package com.sparta.lv2.service;

import com.sparta.lv2.dto.RecordRequestDto;
import com.sparta.lv2.dto.RecordResponseDto;
import com.sparta.lv2.entity.Book;
import com.sparta.lv2.entity.Record;
import com.sparta.lv2.entity.User;
import com.sparta.lv2.repository.BookRepository;
import com.sparta.lv2.repository.RecordRepository;
import com.sparta.lv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

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

        record.setBorrowStatus(0);
        record.setReturnDate(new Date());
        recordRepository.save(record);

        return 1;
    }

    public List<RecordResponseDto> getAllBorrowHistory() {
        List<Record> borrowRecords = recordRepository.findAll();
        List<RecordResponseDto> borrowHistory = new ArrayList<>();
        for (Record record : borrowRecords) {
            Book book = bookRepository.findById(record.getBookId()).orElse(null);
            User user = userRepository.findById(record.getUserId()).orElse(null);
            if (book != null && user != null) {
                borrowHistory.add(new RecordResponseDto(
                        record,
                        book.getTitle(),
                        book.getWriter(),
                        user.getName(),
                        user.getPhoneNum()
                ));
            }
        }
        return borrowHistory;
    }


    @Transactional
    public ResponseEntity borrowBook(Long userId, Long bookId) {
        Book book = bookRepository.findBookByBookId(bookId);
        User user = userRepository.findUserByUserId(userId);
        Record record1 = recordRepository.findByBorrowStatusAndUserId(Book.BORROWED, userId); // BORROWED=대출중, AVAILABLE=대출가능
        Record record2 = recordRepository.findByBorrowStatusAndBookId(Book.BORROWED, bookId);

        if(book == null || user == null) { // 유효하지않은 bookId/userId
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("유효하지않은 bookId/userId");
        } else if(record1 != null || record2 != null) { // 이미 대출중
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 대출중입니다");
        } else {
            Record record = new Record(book, user, new Date());
            record.setBorrowStatus(book.BORROWED);
            recordRepository.save(record);
            book.setBorrowStatus(book.BORROWED);
            return ResponseEntity.ok("대출완료!!");
        }
    }
}
