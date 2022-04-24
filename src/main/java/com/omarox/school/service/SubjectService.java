package com.omarox.school.service;

import com.omarox.school.dao.SubjectDao;
import com.omarox.school.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubjectService {
    private final SubjectDao subjectDao;

    @Autowired
    public SubjectService(@Qualifier("fakeSubjectDao") SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public int addSubject(Subject subject) {
        return subjectDao.insertSubject(subject);
    }

    public List<Subject> getAllSubjects(){
        return subjectDao.selectAllSubjects();
    }

    public Optional<Subject> getSubjectById(UUID id) {
        return subjectDao.selectSubjectById(id);
    }

    public int deleteSubject(UUID id) {
        return subjectDao.deleteSubjectById(id);
    }

    public int updateSubject(UUID id, Subject newSubject) {
        return subjectDao.updateSubjectById(id, newSubject);
    }
}
