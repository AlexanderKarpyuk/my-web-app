package my.web.app.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import my.web.app.dto.UserDto;
import my.web.app.exceptions.ValidationException;
import my.web.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) throws ValidationException {
        log.info("Handling save users: " + userDto);
        return userService.saveUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        log.info("Handling delete user request: " + userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) {
        log.info("Handling find by login request: " + login);
        return userService.findByLogin(login);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll() {
        log.info("Handling find all users request");
        return userService.findAll();
    }
}
