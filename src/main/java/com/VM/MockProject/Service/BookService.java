package com.VM.MockProject.Service;

import com.VM.MockProject.Entity.Book;

import com.VM.MockProject.Repository.IBookRepository;
import com.VM.MockProject.Specification.BookSpecification;
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
        return bookRepository.findAll(BookSpecification.getBooksBySpecification(title, author, genre, publicationYear));
    }
    @Override
    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }
}
