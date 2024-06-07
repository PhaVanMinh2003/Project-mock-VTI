package com.VM.MockProject.Repository;
import com.VM.MockProject.Entity.BorrowRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
@Repository
public interface IBorrowRecordsRepository extends JpaRepository<BorrowRecords, Integer>, JpaSpecificationExecutor<BorrowRecords> {
    // Các phương thức truy vấn tùy chỉnh
}
