package com.omarox.school.dao;

import com.omarox.school.model.Classroom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClassroomDao {
    int insertClassroom(UUID id, Classroom classroom);

    default int insertClassroom(Classroom classroom) {
        UUID id = UUID.randomUUID();
        return insertClassroom(id, classroom);
    }

    List<Classroom> selectAllClassrooms();

    Optional<Classroom> selectClassroomById(UUID id);

    int deleteClassroomById(UUID id);

    int updateClassroomById(UUID id, Classroom newClassroom);
}
