package com.sparta.lv2.service;

import com.sparta.lv2.dto.BookRequestDto;
import com.sparta.lv2.dto.BookResponseDto;
import com.sparta.lv2.entity.Book;
import com.sparta.lv2.entity.User;
import com.sparta.lv2.repository.BookRepository;
import com.sparta.lv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookResponseDto registBook(BookRequestDto requestDto) {
        Book book = new Book(requestDto);
        book.setBorrowStatus(Book.AVAILABLE); // BORROWED=대출가능, AVAILABLE=대출중
        Book savedBook = bookRepository.save(book);
        return new BookResponseDto(savedBook);
    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByDate().stream().map(BookResponseDto::new).toList();
    }

    public BookResponseDto getBook(Long bookId) {
        return new BookResponseDto(bookRepository.findBookByBookId(bookId));
    }

//    @Transactional
//    public ResponseEntity borrowBook(Long userId, Long bookId) {
//        Book book = bookRepository.findBookByBookId(bookId);
//        User user = userRepository.findUserByUserId(userId);
//        Date borrowDate = user.getBorrowDate();
//        Date returnDate = user.getReturnDate();
//
//        if(book == null || user == null) { // 유효하지않은 bookId/userId
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("유효하지않은 bookId/userId");
//        } else if (book.getBorrowStatus() == Book.BORROWED) {                                        // 선택도서가 이미 대출중이거나
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 대출중입니다");
//        } else if ( (borrowDate != null && returnDate == null)
//                || (borrowDate != null && returnDate != null && borrowDate.getTime() > returnDate.getTime()) ) {                // 요청회원이 이미 대출중이면
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 대출중입니다");
//        } else {
//            book.setBorrowStatus(book.BORROWED); // BORROWED=대출가능, AVAILABLE=대출중
//            user.setBorrowBook(bookId.toString());
//            user.setBorrowDate(new Date());
//            return ResponseEntity.ok("대출완료!!");
//        }
//    }
}