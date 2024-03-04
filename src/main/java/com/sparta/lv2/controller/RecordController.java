package com.sparta.lv2.controller;

import com.sparta.lv2.dto.RecordRequestDto;
import com.sparta.lv2.dto.RecordResponseDto;
import com.sparta.lv2.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @PostMapping("/book-return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId) {
        int result = recordService.returnBook(bookId);
        if (result == 1) {
            return new ResponseEntity<>("도서 반납 성공", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("도서 반납 실패", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/what-borrow")
    public ResponseEntity<List<RecordResponseDto>> getAllBorrowHistory() {
        List<RecordResponseDto> borrowHistory = recordService.getAllBorrowHistory();
        return new ResponseEntity<>(borrowHistory, HttpStatus.OK);
    }
}
