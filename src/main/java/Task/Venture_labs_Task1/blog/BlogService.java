package Task.Venture_labs_Task1.blog;

import Task.Venture_labs_Task1.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    Blog addBlog(String text) {
        String action = "new";
        Blog blog = new Blog(text);
        return blogRepository.save(blog);
    }

    Blog deletePostById(int id) {
        String action = "delete";
        Blog blogById = blogRepository.findById(id).orElseThrow();
        blogRepository.delete(blogById);
        return blogById;
    }

    List<Blog> getBlogs(String text, User user) {
        return blogRepository.findAll();
    }

}
