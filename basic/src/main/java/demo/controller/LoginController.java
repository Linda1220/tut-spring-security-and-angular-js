// Copyright Fairfax Media 2014

package demo.controller;

import demo.model.User;
import demo.model.UserDAO;
import demo.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ke.yang on 26/02/2016.
 */
@RestController
public class LoginController extends  UserAbstractController{

    @RequestMapping(path = "/register", method = {RequestMethod.PUT}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AbstractController.Message createUser(@RequestBody UserDTO userDTO) {
        userDAO.save(new User(userDTO));
        return OK;
    }

}
