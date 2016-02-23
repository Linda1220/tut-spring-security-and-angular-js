// Copyright Fairfax Media 2014

package demo.controller;

import demo.model.User;
import demo.model.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ke.yang on 21/02/2016.
 */
@RestController
public class UserRestController extends UserAbstractController {

    @RequestMapping(path = "/user", method = {RequestMethod.PUT}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Message createUser(@RequestBody UserDTO userDTO) {
        userDAO.save(new User(userDTO));
        return OK;
    }

    @RequestMapping(path = "/user", method = {RequestMethod.DELETE})
    public Message deleteUser(long id) {
        userDAO.delete(id);
        return OK;
    }

    @RequestMapping(path = "/user", method = {RequestMethod.POST})
    public Message updateUser(long id, String email, String name, String password) {
        User user = userDAO.findOne(id);
        if (!StringUtils.isEmpty(email)) {
            user.setEmail(email);
        }
        if (!StringUtils.isEmpty(name)) {
            user.setName(name);
        }
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        userDAO.save(user);
        return OK;
    }

    @RequestMapping(path = "/users", method = {RequestMethod.GET})
    public Iterable<User> queryAll() {
        Iterable<User> all = userDAO.findAll();
        return all;
    }
}
