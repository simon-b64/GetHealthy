package at.simon.b64.gethealthybackend.service;

import at.simon.b64.gethealthybackend.persistance.UserRepository;
import at.simon.b64.gethealthybackend.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(userEntity -> new UserDto(
                userEntity.getId(),
                userEntity.getSsoId(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName())
            ).toList();
    }

}
