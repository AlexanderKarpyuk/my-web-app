package my.web.app.service;

import my.web.app.dto.UserDto;
import my.web.app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User fromUserDtoToUser(UserDto usersDto) {
        User user = new User();
        user.setId(usersDto.getId());
        user.setEmail(usersDto.getEmail());
        user.setName(usersDto.getName());
        user.setLogin(usersDto.getLogin());
        return user;
    }

    public UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .name(user.getName())
                .build();
    }
}
