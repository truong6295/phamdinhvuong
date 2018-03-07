package com.vuong.repo;

import com.vuong.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
