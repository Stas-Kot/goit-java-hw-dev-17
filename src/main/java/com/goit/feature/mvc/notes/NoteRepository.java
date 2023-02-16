package com.goit.feature.mvc.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
//    @Query(nativeQuery = true, value = "SELECT note_id as noteId, user_id, title, content FROM notes")
//    List<Note> getAllNotesCustom();

    @Query(nativeQuery = true, value = "SELECT note_id as noteId, user_id, title, content FROM notes WHERE user_name = :username;")
    List<Note> getAllNotesByUserName(@Param("username") String name);
}
