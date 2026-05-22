package demo.demo.service.user;

import demo.demo.repository.user.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDeleterService {
    private final JpaUserRepository jpaUserRepository;

    public UserDeleterService(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public void delete(Long id){
        jpaUserRepository.deleteById(id);
    }
}
