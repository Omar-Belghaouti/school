package com.omarox.school.service;

import com.omarox.school.dao.TeacherDao;
import com.omarox.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {
    private final TeacherDao teacherDao;

    @Autowired
    public TeacherService(@Qualifier("fakeTeacherDao") TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public int addTeacher(Teacher teacher) {
        return teacherDao.insertTeacher(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDao.selectAllTeachers();
    }

    public Optional<Teacher> getTeacherById(UUID id) {
        return teacherDao.selectTeacherById(id);
    }

    public int deleteTeacher(UUID id) {
        return teacherDao.deleteTeacherById(id);
    }

    public int updateTeacher(UUID id, Teacher newTeacher) {
        return teacherDao.updateTeacherById(id, newTeacher);
    }
}
