package demo.demo.service.user;

import demo.demo.dto.request.user.UserRequest;
import demo.demo.mapper.user.UserMapper;
import demo.demo.model.user.User;
import demo.demo.repository.user.JpaUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorService {
    private JpaUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserCreatorService(
            JpaUserRepository jpaUserRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserRequest request) {
        User user = UserMapper.requestToUser(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return jpaUserRepository.save(user);
    }
}
