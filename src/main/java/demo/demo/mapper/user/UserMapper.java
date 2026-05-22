package demo.demo.mapper.user;

import demo.demo.dto.request.user.UserRequest;
import demo.demo.dto.response.user.UserResponse;
import demo.demo.model.user.User;

public class UserMapper {

    public static User requestToUser(UserRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setDni(request.getDni());
        return user;
    }

    public static UserResponse userToResponse(User user){
                return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getDni()
        );
    }
}
