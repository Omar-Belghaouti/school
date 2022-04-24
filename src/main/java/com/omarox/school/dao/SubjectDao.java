package com.omarox.school.dao;

import com.omarox.school.model.Subject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubjectDao {
    int insertSubject(UUID id, Subject subject);

    default int insertSubject(Subject subject) {
        UUID id = UUID.randomUUID();
        return insertSubject(id, subject);
    }

    List<Subject> selectAllSubjects();

    Optional<Subject> selectSubjectById(UUID id);

    int deleteSubjectById(UUID id);

    int updateSubjectById(UUID id, Subject newSubject);
}
