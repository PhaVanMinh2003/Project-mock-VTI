package com.VM.MockProject.Repository;

import com.VM.MockProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    // Các phương thức truy vấn tùy chỉnh
}
