// Copyright Fairfax Media 2014

package demo.controller;

import demo.model.User;
import demo.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ke.yang on 21/02/2016.
 */
@RestController
public class UserController extends AbstractController{

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(path = "/user", method = {RequestMethod.PUT})
    public User createUser(String email, String name) {
        User user = new User(email, name);
        userDAO.save(user);
        return user;
    }

    @RequestMapping(path = "/user", method = {RequestMethod.DELETE})
    public Message deleteUser(long id) {
        userDAO.delete(id);
        return OK;
    }

    @RequestMapping(path = "/user", method = {RequestMethod.POST})
    public Message updateUser(long id, String email, String name) {
        User user = userDAO.findOne(id);
        if(!StringUtils.isEmpty(email)){user.setEmail(email);}
        if(!StringUtils.isEmpty(name)){user.setName(name);}
        userDAO.save(user);
        return OK;
    }
}
