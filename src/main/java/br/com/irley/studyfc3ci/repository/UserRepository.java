package br.com.irley.studyfc3ci.repository;

import br.com.irley.studyfc3ci.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    public UUID create(User user);

    public List<User> findAll();

    public Optional<User> findById(UUID userId);

    public void remove(User user);
}
