package Task.Venture_labs_Task1;

import Task.Venture_labs_Task1.blog.Blog;
import Task.Venture_labs_Task1.blog.BlogRepository;
import Task.Venture_labs_Task1.user.User;
import Task.Venture_labs_Task1.user.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class BlogInitializer {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogInitializer(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }
 //example for database
    @PostConstruct
    void init() {
        User user = new User(1, "admin", "admin", "superUser", "yes");
        Blog blog = new Blog(1, "test", user);
        userRepository.save(user);//send create user to repository
        blogRepository.save(blog);//send create blog to repository

    }
}
