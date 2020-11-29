package my.web.app.service;

import lombok.AllArgsConstructor;
import my.web.app.dto.UserDto;
import my.web.app.entity.User;
import my.web.app.exceptions.ValidationException;
import my.web.app.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class DefaultUserService implements UserService{
    private final UserConverter userConverter;
    private final UsersRepository usersRepository;

    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException{
        validateUserDto(userDto);
        User savedUser = usersRepository.save(userConverter.fromUserDtoToUser(userDto));
        return userConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String login) {
        User user = usersRepository.findByLogin(login);
        return user != null ? userConverter.fromUserToUserDto(user) : null;
    }

    @Override
    public List<UserDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

    private void validateUserDto(UserDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }
}
