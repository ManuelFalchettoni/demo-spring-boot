package demo.demo.controller.user;

import demo.demo.dto.request.user.UserRequest;
import demo.demo.dto.response.user.UserResponse;
import demo.demo.mapper.user.UserMapper;
import demo.demo.service.user.UserCreatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserPostController {
    private final UserCreatorService userCreatorService;

    public UserPostController(UserCreatorService userCreatorService) {
        this.userCreatorService = userCreatorService;
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request){
        UserResponse response = UserMapper.userToResponse(userCreatorService.create(request));
        return ResponseEntity.ok(response);
    }
}
