package com.omarox.school.dao;

import com.omarox.school.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeTeacherDataAccessService implements TeacherDao {
    private static final List<Teacher> DB = new ArrayList<>();

    @Override
    public int insertTeacher(UUID id, Teacher teacher) {
        DB.add(new Teacher(
                id,
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getClassrooms(),
                teacher.getSubject()
        ));
        return 1;
    }

    @Override
    public List<Teacher> selectAllTeachers() {
        return DB;
    }

    @Override
    public Optional<Teacher> selectTeacherById(UUID id) {
        return DB.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTeacherById(UUID id) {
        Optional<Teacher> teacherMaybe = selectTeacherById(id);
        if (teacherMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(teacherMaybe.get());
        return 1;
    }

    @Override
    public int updateTeacherById(UUID id) {
        return selectTeacherById(id)
                .map(teacher -> {
                    int indexOfTeacherToUpdate = DB.indexOf(teacher);
                    if (indexOfTeacherToUpdate >= 0) {
                        DB.set(indexOfTeacherToUpdate, new Teacher(
                                id,
                                teacher.getFirstName(),
                                teacher.getLastName(),
                                teacher.getClassrooms(),
                                teacher.getSubject()
                        ));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
