package peaksoft.service.serviceImpl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.jwt.JwtUtil;
import peaksoft.dto.requests.UserRegisterRequest;
import peaksoft.dto.responses.UserRegisterResponse;
import peaksoft.entity.User;
import peaksoft.enums.Role;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserRegisterResponse authenticate(UserRegisterRequest userRegisterRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRegisterRequest.email(),
                        userRegisterRequest.password()
                )
        );
        User user = userRepository.findByEmail(userRegisterRequest.email())
                .orElseThrow(() -> new NoSuchElementException(String.format
                        ("User with email: %s doesn't exists", userRegisterRequest.email())));
        String token = jwtUtil.generateToken(user);

        return UserRegisterResponse.builder()
                .token(token)
                .email(user.getEmail())
                .build();

    }


    @PostConstruct
    public void init() {
        User user=new User();
        user.setFirstName("Admin");
        user.setLastName("Adminov");
        user.setPhoneNumber("0996507454545");
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin124578"));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
