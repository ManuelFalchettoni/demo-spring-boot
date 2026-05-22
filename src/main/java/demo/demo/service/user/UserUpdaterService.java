package demo.demo.service.user;

import demo.demo.dto.request.user.UserRequest;
import demo.demo.model.user.User;
import demo.demo.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserUpdaterService {
    private final JpaUserRepository jpaUserRepository;
    private final UserFinderService userFinderService;

    public UserUpdaterService(JpaUserRepository jpaUserRepository, UserFinderService userFinderService) {
        this.jpaUserRepository = jpaUserRepository;
        this.userFinderService = userFinderService;
    }

    public User update(UserRequest request, Long id){
        User user = userFinderService.find(id);
        user.setDni(request.getDni());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        return jpaUserRepository.save(user);
    }
}
