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
        book.setBorrowStatus(Book.AVAILABLE); // BORROWED=대출중, AVAILABLE=대출가능
        Book savedBook = bookRepository.save(book);
        return new BookResponseDto(savedBook);
    }

    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByDate().stream().map(BookResponseDto::new).toList();
    }

    public BookResponseDto getBook(Long bookId) {
        return new BookResponseDto(bookRepository.findBookByBookId(bookId));
    }
}