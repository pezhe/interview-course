package ru.pezhe.lesson7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pezhe.lesson7.entity.Student;
import ru.pezhe.lesson7.repository.StudentDao;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentDao studentDao;

    @GetMapping
    public String getList(Model model) {
        model.addAttribute("students", studentDao.findAll());
        return "student-list";
    }

    @GetMapping("/form")
    public String getForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Student student;

        if (id != null) {
            student = studentDao.findById(id).orElse(new Student());
        } else {
            student = new Student();
        }
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/form")
    public String save(Student student) {
        studentDao.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        studentDao.deleteById(id);
        return "redirect:/students";
    }

}
