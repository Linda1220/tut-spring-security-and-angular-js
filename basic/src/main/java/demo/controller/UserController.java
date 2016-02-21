// Copyright Fairfax Media 2014

package demo.controller;

import demo.model.User;
import demo.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ke.yang on 21/02/2016.
 */
@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/create")
    public User createUser(String email, String name) {
        User user = new User(email, name);
        userDAO.save(user);
        return user;
    }
}
