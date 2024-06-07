package com.VM.MockProject.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "role_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name = "role_name", nullable = false, unique = true, length = 50)
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}