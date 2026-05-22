package demo.demo.service.user;

import demo.demo.dto.request.user.UserRequest;
import demo.demo.mapper.user.UserMapper;
import demo.demo.model.user.User;
import demo.demo.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorService {
    private JpaUserRepository jpaUserRepository;

    public UserCreatorService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User create(UserRequest request){
        User user = UserMapper.requestToUser(request);
        return jpaUserRepository.save(user);
    }
}
