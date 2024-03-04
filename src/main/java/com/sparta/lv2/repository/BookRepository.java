package com.sparta.lv2.repository;

import com.sparta.lv2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByDate();
    Book findBookByBookId(Long bookId);
}