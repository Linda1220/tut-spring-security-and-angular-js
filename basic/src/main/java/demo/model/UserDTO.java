package demo.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Linda on 22/02/16.
 */
public class UserDTO implements Serializable{
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String source;
    public UserDTO() {
    }

    public UserDTO(String email, String firstName, String lastName, String username, String password, String source) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
