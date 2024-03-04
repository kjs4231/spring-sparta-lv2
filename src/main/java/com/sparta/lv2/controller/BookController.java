package com.sparta.lv2.controller;

import com.sparta.lv2.dto.BookRequestDto;
import com.sparta.lv2.dto.BookResponseDto;
import com.sparta.lv2.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book-regist")
    public BookResponseDto registBook(@RequestBody BookRequestDto requestDto) {
        return bookService.registBook(requestDto);
    }

    @GetMapping("")
    public List<BookResponseDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public BookResponseDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }
}