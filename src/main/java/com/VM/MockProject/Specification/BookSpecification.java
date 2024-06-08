package com.VM.MockProject.Specification;

import com.VM.MockProject.Entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

@SuppressWarnings("deprecation")
public class BookSpecification {

    public static Specification<Book> getBooksBySpecification(String title, String author, String genre, Integer publicationYear) {
        return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate = builder.conjunction();

            if (title != null && !title.isEmpty()) {
                predicate = builder.and(predicate, builder.like(root.get("title"), "%" + title + "%"));
            }
            if (author != null && !author.isEmpty()) {
                predicate = builder.and(predicate, builder.like(root.get("author"), "%" + author + "%"));
            }
            if (genre != null && !genre.isEmpty()) {
                predicate = builder.and(predicate, builder.like(root.get("genre"), "%" + genre + "%"));
            }
            if (publicationYear != null) {
                predicate = builder.and(predicate, builder.equal(root.get("publicationYear"), publicationYear));
            }

            return predicate;
        };
    }
}
