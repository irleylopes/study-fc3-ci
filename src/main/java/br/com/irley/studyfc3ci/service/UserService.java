package br.com.irley.studyfc3ci.service;

import br.com.irley.studyfc3ci.controller.CreateUserRequest;
import br.com.irley.studyfc3ci.domain.User;
import br.com.irley.studyfc3ci.domain.UserNotFoundException;
import br.com.irley.studyfc3ci.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UUID create(CreateUserRequest request) {
        User user = new User(
                UUID.randomUUID(),
                request.getName(),
                request.getMail()
        );
        return userRepository.create(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found for ID = ".concat(userId.toString()));
        }
        return user.get();
    }

    public void remove(UUID userId) throws UserNotFoundException {
        User user = findById(userId);
        userRepository.remove(user);
    }
}
