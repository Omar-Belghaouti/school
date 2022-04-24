package com.omarox.school.dao;

import com.omarox.school.model.Classroom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeClassroomDao")
public class FakeClassroomDataAccessService implements ClassroomDao {
    private static final List<Classroom> DB = new ArrayList<>();
    @Override
    public int insertClassroom(UUID id, Classroom classroom) {
        DB.add(new Classroom(id, classroom.getTeachers(), classroom.getStudents()));
        return 1;
    }

    @Override
    public List<Classroom> selectAllClassrooms() {
        return DB;
    }

    @Override
    public Optional<Classroom> selectClassroomById(UUID id) {
        return DB.stream()
                .filter(classroom -> classroom.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClassroomById(UUID id) {
        Optional<Classroom> classroomMaybe = selectClassroomById(id);
        if (classroomMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(classroomMaybe.get());
        return 1;
    }

    @Override
    public int updateClassroomById(UUID id, Classroom newClassroom) {
        return selectClassroomById(id)
                .map(classroom -> {
                    int indexOfClassroomToUpdate = DB.indexOf(classroom);
                    if (indexOfClassroomToUpdate >= 0) {
                        DB.set(indexOfClassroomToUpdate, new Classroom(id, newClassroom.getTeachers(), newClassroom.getStudents()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
