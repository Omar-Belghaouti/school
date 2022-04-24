package com.omarox.school.dao;

import com.omarox.school.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeSubjectDataAccessService implements SubjectDao {
    private static final List<Subject> DB = new ArrayList<>();

    @Override
    public int insertSubject(UUID id, Subject subject) {
        DB.add(new Subject(id, subject.getName()));
        return 1;
    }

    @Override
    public List<Subject> selectAllSubjects() {
        return DB;
    }

    @Override
    public Optional<Subject> selectSubjectById(UUID id) {
        return DB.stream()
                .filter(subject -> subject.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteSubjectById(UUID id) {
        Optional<Subject> subjectMaybe = selectSubjectById(id);
        if (subjectMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(subjectMaybe.get());
        return 1;
    }

    @Override
    public int updateSubjectById(UUID id) {
        return selectSubjectById(id)
                .map(subject -> {
                    int indexOfSubjectToUpdate = DB.indexOf(subject);
                    if (indexOfSubjectToUpdate >= 0) {
                        DB.set(indexOfSubjectToUpdate, new Subject(id, subject.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
