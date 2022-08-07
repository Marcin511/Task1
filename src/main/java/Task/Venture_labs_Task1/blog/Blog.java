package Task.Venture_labs_Task1.blog;
/*
Here I created Table Blog
*/

import Task.Venture_labs_Task1.user.User;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user; // Here I send whole user because userId is foreign key

    public Blog() {
    }
    // create constructor for addBlog method
    public Blog(String text) {
        this.text = text;
    }


    public Blog(int id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
