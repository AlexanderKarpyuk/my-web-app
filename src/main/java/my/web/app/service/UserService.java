package my.web.app.service;

import my.web.app.dto.UserDto;
import my.web.app.exceptions.ValidationException;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto) throws ValidationException;
    void deleteUser(Integer userId);
    UserDto findByLogin(String login);
    List<UserDto> findAll();
}
