package Task.Venture_labs_Task1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
        //Method to add user checking if user exist then throw exception
    User addUser(Integer userId, String userName, String password, String permission, String readOnly) {
        String action = "new_user";
        User user = new User(userId, userName, password, permission, readOnly);
        userRepository.findByUserName(user.getUserName()).ifPresent(u -> {
            try {
                throw new IllegalAccessException("User already Exist");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return userRepository.save(user);
    }
        //Method login checking if userName and password exist then do action login
    User login(String userName, String password) {
        String action = "login";
        return userRepository.findByUserNameAndPassword(userName, password).orElseThrow(() -> new NoSuchElementException("Wrong username or password"));
    }

}
