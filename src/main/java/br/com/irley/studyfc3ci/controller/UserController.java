package br.com.irley.studyfc3ci.controller;

import br.com.irley.studyfc3ci.domain.User;
import br.com.irley.studyfc3ci.domain.UserNotFoundException;
import br.com.irley.studyfc3ci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) throws UserNotFoundException {
        return userService.findById(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID create(@RequestBody CreateUserRequest createUserRequest) {
        return userService.create(createUserRequest);
    }

//    @PutMapping("/{id}")
//    public Mono<Exemplo> updateExemplo(@PathVariable("id") String id, @RequestBody Exemplo exemplo) {
//        return exemploService.updateExemplo(id, exemplo);
//    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") String id) throws UserNotFoundException {
        userService.remove(UUID.fromString(id));
    }
}
