package com.goit.feature.mvc.notes;

import com.goit.feature.mvc.user.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name="notes")
public class Note {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="note_id")
    private long noteId;

    @Column
    private String title;

    @Column
    private String content;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
