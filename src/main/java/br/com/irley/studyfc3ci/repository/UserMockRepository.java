package br.com.irley.studyfc3ci.repository;

import br.com.irley.studyfc3ci.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserMockRepository implements UserRepository {

    private List<User> users = new ArrayList<User>() {{
        add(new User(UUID.fromString("3841c0b4-fe1c-4bd7-9daa-7b8b46dc6c2b"), "Pedro", "pedro@mail"));
        add(new User(UUID.fromString("463b292d-248b-46af-b3c8-0dca55c60922"), "Maria", "maria@mail"));
        add(new User(UUID.fromString("1eee054b-bb74-470a-af4d-446cf0108e48"), "Joao", "joao@mail"));
        add(new User(UUID.fromString("e56d9d95-a6e6-45a5-a6be-579708e59c4a"), "Manoel", "manoel@mail"));
        add(new User(UUID.fromString("4afb20f6-99c4-453e-b61d-fe3382bb8860"), "Sebastiao", "sebastiao@mail"));
    }};

    public UserMockRepository() {
    }

    @Override
    public UUID create(User user) {
        users.add(user);
        return user.getId();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst();
    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }
}
