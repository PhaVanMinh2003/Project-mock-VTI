package com.VM.MockProject.Service;

import com.VM.MockProject.Entity.Book;

import com.VM.MockProject.Repository.IBookRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> updateBook(Integer bookId, Book bookDetails) {
        return bookRepository.findById(bookId).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setPublicationYear(bookDetails.getPublicationYear());
            book.setQuantity(bookDetails.getQuantity());
            return bookRepository.save(book);
        });
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String title, String author, String genre, Integer publicationYear) {
        // Logic tìm kiếm sách theo các tiêu chí, có thể sử dụng Specification hoặc các phương thức query trong repository
        // Ví dụ:
        return bookRepository.findAll((root, query, builder) -> {
            Predicate p = builder.conjunction();
            if (title != null && !title.isEmpty()) {
                p = builder.and(p, builder.like(root.get("title"), "%" + title + "%"));
            }
            if (author != null && !author.isEmpty()) {
                p = builder.and(p, builder.like(root.get("author"), "%" + author + "%"));
            }
            if (genre != null && !genre.isEmpty()) {
                p = builder.and(p, builder.like(root.get("genre"), "%" + genre + "%"));
            }
            if (publicationYear != null) {
                p = builder.and(p, builder.equal(root.get("publicationYear"), publicationYear));
            }
            return p;
        });

    }
    @Override
    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }
}
