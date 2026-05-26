package demo.demo.service.auth;

import demo.demo.dto.request.auth.LoginRequest;
import demo.demo.dto.response.auth.LoginResponse;
import demo.demo.exception.auth.WrongPasswordException;
import demo.demo.exception.user.UserNotFoundByEmailException;
import demo.demo.model.user.User;
import demo.demo.repository.user.JpaUserRepository;
import demo.demo.service.jwt.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(
            JpaUserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundByEmailException(request.getEmail()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }

        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}