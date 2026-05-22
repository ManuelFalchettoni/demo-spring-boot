package demo.demo.controller.user;

import demo.demo.dto.request.user.UserRequest;
import demo.demo.dto.response.user.UserResponse;
import demo.demo.mapper.user.UserMapper;
import demo.demo.model.user.User;
import demo.demo.service.user.UserUpdaterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserPutController {
    private final UserUpdaterService userUpdaterService;

    public UserPutController(UserUpdaterService userUpdaterService) {
        this.userUpdaterService = userUpdaterService;
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UserRequest request, @PathVariable Long id){
        User user = userUpdaterService.update(request,id);
        return ResponseEntity.ok(UserMapper.userToResponse(user));
    }
}
