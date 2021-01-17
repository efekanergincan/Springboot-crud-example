package com.lessons.crud.example.controller;


import com.lessons.crud.example.entity.Lesson;
import com.lessons.crud.example.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private LessonService service;

    @PostMapping("/addLesson")
    public Lesson addLesson(@RequestBody Lesson lesson){return  service.saveLesson(lesson);}
    @PostMapping("/addLessons")
    public List<Lesson> addLessons(@RequestBody List<Lesson> lessons){return service.saveLessons(lessons);}

    @GetMapping("/lessons")
    public List<Lesson> findAllLessons(){return service.getLessons();}
    @GetMapping("/lessonById/{id}")
    public Lesson findLessonById(@PathVariable int id){return service.getLessonById(id);}
    @GetMapping("/lesson/{name}")
    public Lesson findLessonByName(@PathVariable String name){return service.getLessonByName(name);}

    @PutMapping("/update")
    public Lesson updateLessons(@RequestBody Lesson lesson){return service.updateLesson(lesson);}
    @DeleteMapping("/delete/{id}")
    public String deleteLesson(@PathVariable int id){return service.deleteLesson(id);}

}
