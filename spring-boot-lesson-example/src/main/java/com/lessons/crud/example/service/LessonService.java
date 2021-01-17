package com.lessons.crud.example.service;

import com.lessons.crud.example.entity.Lesson;
import com.lessons.crud.example.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository repository;

    public Lesson saveLesson(Lesson lesson){return repository.save(lesson);}
    public List<Lesson> saveLessons(List<Lesson> lessons){return repository.saveAll(lessons);}

    public List<Lesson> getLessons(){ return repository.findAll();}
    public Lesson getLessonById(int id){
        return repository.findById(id).orElse(null);
    }
    public Lesson getLessonByName(String name){ return repository.findByName(name);}

    public String deleteLesson(int id){
        repository.deleteById(id);
        return "Lesson removed!"+id;
    }
    public Lesson updateLesson(Lesson lesson){
        Lesson existingLesson=repository.findById(lesson.getId()).orElse(null);
        existingLesson.setName(lesson.getName());
        existingLesson.setResults(lesson.getResults());
        return repository.save(existingLesson);
    }

}
