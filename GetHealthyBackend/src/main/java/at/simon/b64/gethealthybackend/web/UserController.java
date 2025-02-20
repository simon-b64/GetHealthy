package at.simon.b64.gethealthybackend.web;

import at.simon.b64.gethealthybackend.service.UserService;
import at.simon.b64.gethealthybackend.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAllUsers();
    }

}
