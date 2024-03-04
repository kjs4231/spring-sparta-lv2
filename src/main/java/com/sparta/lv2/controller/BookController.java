package com.sparta.lv2.controller;

import com.sparta.lv2.dto.BookRequestDto;
import com.sparta.lv2.dto.BookResponseDto;
import com.sparta.lv2.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book-regist")
    public ResponseEntity<BookResponseDto> registBook(@RequestBody BookRequestDto requestDto) {
        BookResponseDto responseDto = bookService.registBook(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponseDto>> getBooks() {
        List<BookResponseDto> bookResponseDtoList = bookService.getBooks();
        return ResponseEntity.ok(bookResponseDtoList);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long bookId) {
        BookResponseDto responseDto = bookService.getBook(bookId);
        if (responseDto != null) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}