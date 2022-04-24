package com.omarox.school.dao;

import com.omarox.school.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeStudentDao")
public class FakeStudentDataAccessService implements StudentDao {
    private static final List<Student> DB = new ArrayList<>();

    @Override
    public int insertStudent(UUID id, Student student) {
        DB.add(
                new Student(
                        id,
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge(),
                        student.getTeachers(),
                        student.getSubjects(),
                        student.getClassroomId()
                )
        );
        return 1;
    }

    @Override
    public List<Student> selectAllStundents() {
        return DB;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return DB.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteStudentById(UUID id) {
        Optional<Student> studentMaybe = selectStudentById(id);
        if (studentMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(studentMaybe.get());
        return 1;
    }

    @Override
    public int updateStudentById(UUID id, Student newStudent) {
        return selectStudentById(id)
                .map(student -> {
                    int indexOfStudentToUpdate = DB.indexOf(student);
                    if (indexOfStudentToUpdate >= 0) {
                        DB.set(indexOfStudentToUpdate, new Student(
                                id,
                                newStudent.getFirstName(),
                                newStudent.getLastName(),
                                newStudent.getAge(),
                                newStudent.getTeachers(),
                                newStudent.getSubjects(),
                                newStudent.getClassroomId())
                        );
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
