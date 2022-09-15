package ru.pezhe.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pezhe.lesson7.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
}
