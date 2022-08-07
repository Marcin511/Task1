package Task.Venture_labs_Task1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog/user") /* I change a little this endpoint because blogController and userController cannot connect
                               in the same path */
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // Method to login endpoint: domain/blog/user?action=login&userName=admin&password=admin
    @GetMapping
    User login(@RequestParam String action,
               @RequestParam String userName,
               @RequestParam String password) {
        return userService.login(userName, password);
    }
    //Method to add new user endpoint domain/blog/user?action=new_user&userName=admin4&password=admin4&permission=normalUser&readOnly=yes
    @PostMapping
    User addUser(@RequestParam String action,
                 @RequestParam(required = false) Integer userId,
                 @RequestParam String userName,
                 @RequestParam String password,
                 @RequestParam String permission,
                 @RequestParam String readOnly) {
        return userService.addUser(userId, userName, password, permission, readOnly);
    }
}
