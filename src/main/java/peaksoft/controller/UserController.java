package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.requests.UserRegisterRequest;
import peaksoft.dto.responses.UserRegisterResponse;
import peaksoft.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserRegisterResponse login(@RequestBody UserRegisterRequest userRequest) {
        return userService.authenticate(userRequest);
    }


}
