package com.amdocs.assignment.repository;

import com.amdocs.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<User, Long> {
}
