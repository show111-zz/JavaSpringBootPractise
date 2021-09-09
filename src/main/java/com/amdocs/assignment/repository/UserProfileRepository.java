package com.amdocs.assignment.repository;

import com.amdocs.assignment.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<Profile, Long> {
}
