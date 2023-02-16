package com.goit.feature.mvc.notes;

import com.goit.feature.mvc.security.SecurityService;
import com.goit.feature.mvc.user.User;
import com.goit.feature.mvc.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository repository;
    private final UserRepository userRepository;
//    private final SecurityService securityService;
    private final NamedParameterJdbcTemplate jdbcTemplate;
//    private final CustomJdbcUserDetailsService customUserDetailsService;

    public List<Note> getListByUser() {
        return jdbcTemplate.query(
                "SELECT note_id as noteId, user_name, title, content FROM notes WHERE user_name = :username;",
//                Map.of("username", securityService.getUsername()),
                new NoteDataMapper());
    }

    public List<Note> getNoteList() {
        return repository.findAll();
    }

    public synchronized Note add(Note note) {
//        User user = userRepository.findByUsername(securityService.getUsername()).orElseThrow(IllegalArgumentException::new);
//        note.setUser(user);
        return repository.save(note);
    }

    public Note getById(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public synchronized void deleteById(long id) {
        repository.deleteById(id);
    }

    @Component
    private static class NoteDataMapper implements RowMapper<Note> {
        @Override
        public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
            Note res = new Note();
            res.setNoteId(rs.getLong("note_id"));
            res.setTitle(rs.getString("title"));
            res.setContent(rs.getString("content"));
            String user_name = rs.getString("user_name");

            return res;
        }
    }
}
