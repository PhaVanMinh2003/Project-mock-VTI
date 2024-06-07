package com.VM.MockProject.Controller;

import com.VM.MockProject.Entity.Book;

import com.VM.MockProject.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/v1/books")
@Validated
public class BookController {
    @Autowired
    private IBookService bookservice;

    @PostMapping
    public ResponseEntity<Book> addbook(@RequestBody Book book){
        Book savedBook = bookservice.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/{bookId}") // Đã thêm {bookId} ở đây
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody Book BookDetails) {
        Optional<Book> updatedBook = bookservice.updateBook(bookId, BookDetails);
        return updatedBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deletedBook(@PathVariable Integer bookId){
        bookservice.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookservice.getAllBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    // Endpoint tìm kiếm sách theo các tiêu chí
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer publicationYear) {
        return ResponseEntity.ok(bookservice.searchBooks(title, author, genre, publicationYear));
    }
    // Endpoint lấy thông tin chi tiết sách
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        return bookservice.getBookById(bookId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
