package com.VM.MockProject.Service;

import com.VM.MockProject.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book addBook(Book book);

    Optional<Book> updateBook(Integer bookId, Book bookDetails);

    void deleteBook(Integer bookId);

    List<Book> getAllBooks();

    List<Book> searchBooks(String title, String author, String genre, Integer publicationYear);

    // Thêm phương thức lấy thông tin chi tiết sách
    Optional<Book> getBookById(Integer bookId);
}

