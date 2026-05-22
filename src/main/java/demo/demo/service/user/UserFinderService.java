package demo.demo.service.user;

import demo.demo.exception.user.UserNotFoundException;
import demo.demo.model.user.User;
import demo.demo.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinderService {
    private final JpaUserRepository jpaUserRepository;

    public UserFinderService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User find(Long id){
        return jpaUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
