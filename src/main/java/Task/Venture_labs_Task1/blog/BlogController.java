package Task.Venture_labs_Task1.blog;

import Task.Venture_labs_Task1.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class  BlogController {
    private final BlogService blogService;

    @Autowired
    BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping //Method to finding all blogs
    List<Blog> getBlogs(String text, User user) {
        return blogService.getBlogs(text, user);
    }

    @PostMapping //Method to add blog
    Blog addBlog(@RequestParam String action,
                 @RequestParam String text
    ) {
        return blogService.addBlog(text);
    }

    @DeleteMapping //Method to delete blog
    Blog deleteBlogById(@RequestParam String action,
                        @RequestParam Integer id) {
        return blogService.deletePostById(id);
    }
}
