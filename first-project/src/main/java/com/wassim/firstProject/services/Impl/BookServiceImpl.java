package com.wassim.firstProject.services.Impl;

import com.wassim.firstProject.entities.Book;
import com.wassim.firstProject.repositories.BookRepository;
import com.wassim.firstProject.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}
