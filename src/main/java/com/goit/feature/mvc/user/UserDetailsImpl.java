package com.goit.feature.mvc.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goit.feature.mvc.notes.Note;
import com.goit.feature.mvc.user.roles.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
//@Component
public class UserDetailsImpl implements UserDetails {
    private final Long id;
    private final String username;

    @JsonIgnore
    private final String password;
    private final List<Note> notes;
    private final Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(User user) {
        Role role = user.getRole();
        Set<GrantedAuthority> authorities = Collections.singleton(() -> role.getName().name());
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getNotes(),
                authorities

        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
