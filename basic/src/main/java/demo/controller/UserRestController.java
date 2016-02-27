// Copyright Fairfax Media 2014

package demo.controller;

import demo.model.User;
import demo.model.UserDTO;
import demo.util.NullAwareBeanUtil;
import java.lang.reflect.InvocationTargetException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Message deleteUser(@RequestBody UserDTO userDTO) {
        userDAO.delete(userDTO.getId());
        return OK;
    }

    @RequestMapping(path = "/user", method = {RequestMethod.POST})
    public Message updateUser(@RequestBody UserDTO userDTO) throws InvocationTargetException, IllegalAccessException {
        User user = userDAO.findOne(userDTO.getId());
        NullAwareBeanUtil.copyProperties(userDTO, user);
        userDAO.save(user);
        return OK;
    }

    @RequestMapping(path = "/users", method = {RequestMethod.GET})
    public Iterable<User> getAll() {
        Iterable<User> all = userDAO.findAll();
        return all;
    }

    @RequestMapping(path = "/user", method = {RequestMethod.GET})
    public User getById(@RequestBody UserDTO userDTO){
        User user = userDAO.findOne(userDTO.getId());
        return user;
    }

    @RequestMapping(path = "/user/{username}", method = {RequestMethod.GET})
    public User getByUsername(@PathVariable String username){
        User user = userDAO.findByUsername(username);
        return user;
    }

    @RequestMapping(path = "/user/{email}", method = {RequestMethod.GET})
    public User getByEmail(@PathVariable String email){
        User user = userDAO.findByEmail(email);
        return user;
    }
}
