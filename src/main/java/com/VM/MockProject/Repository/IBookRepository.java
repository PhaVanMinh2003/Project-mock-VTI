package com.VM.MockProject.Repository;

import com.VM.MockProject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
    // Các phương thức truy vấn tùy chỉnh
}
