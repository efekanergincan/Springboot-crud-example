package com.lessons.crud.example.repository;

import com.lessons.crud.example.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    Lesson findByName(String name);
}
