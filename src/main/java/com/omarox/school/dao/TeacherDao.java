package com.omarox.school.dao;

import com.omarox.school.model.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeacherDao {
    int insertTeacher(UUID id, Teacher teacher);

    default int insertTeacher(Teacher teacher) {
        UUID id = UUID.randomUUID();
        return  insertTeacher(id, teacher);
    }

    List<Teacher> selectAllTeachers();

    Optional<Teacher> selectTeacherById(UUID id);

    int deleteTeacherById(UUID id);

    int updateTeacherById(UUID id, Teacher newTeacher);
}
