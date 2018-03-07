package com.vuong.repo;

import com.vuong.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepo extends JpaRepository<Personal, Integer> {
}
