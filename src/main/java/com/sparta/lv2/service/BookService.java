package com.sparta.lv2.service;

import com.sparta.lv2.dto.BookRequestDto;
import com.sparta.lv2.dto.BookResponseDto;
import com.sparta.lv2.entity.Book;
import com.sparta.lv2.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponseDto registBook(BookRequestDto requestDto) {
        Book book = new Book(requestDto);
        book.setBorrowStatus(0); // 0 = 대출가능, 1 = 대출중, 예약중/상호대차 등을 고려 boolean이 아닌 int로 선언
        Book saveBook = bookRepository.save(book);
        BookResponseDto responseDto = new BookResponseDto(saveBook);
        return responseDto;
    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByDate().stream().map(BookResponseDto::new).toList();
    }

    public BookResponseDto getBook(Long bookId) {
        return new BookResponseDto(bookRepository.findBookByBookId(bookId));
    }
}