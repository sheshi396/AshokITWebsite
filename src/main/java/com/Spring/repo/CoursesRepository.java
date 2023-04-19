package com.Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
