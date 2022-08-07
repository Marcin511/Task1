package Task.Venture_labs_Task1.user;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

interface AddUser {
}

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @NotNull(groups = AddUser.class)
    @Max(value = 45, groups = {AddUser.class,})
    private String userName;
    @Size(min = 5, max = 45, groups = {AddUser.class}) // I set minimum size of password
    private String password;
    @Max(value = 45, groups = {AddUser.class})
    private String permission;
    @Max(value = 45, groups = {AddUser.class})
    private String readOnly;

    public User() {
    }

    public User(int userId, String userName, String password, String premission, String readOnly) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.permission = premission;
        this.readOnly = readOnly;
    }

    public User(String userName, String password, String permission, String readOnly) {
        this.userName = userName;
        this.password = password;
        this.permission = permission;
        this.readOnly = readOnly;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }
}
