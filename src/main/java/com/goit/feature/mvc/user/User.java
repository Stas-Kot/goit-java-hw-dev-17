package com.goit.feature.mvc.user;

import com.goit.feature.mvc.notes.Note;
import com.goit.feature.mvc.user.roles.Role;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="users",
uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
//    @Id
//    @Column(name = "id")
    @Column(name = "username", nullable = false, unique = true, length = 200)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Note> notes;
}
