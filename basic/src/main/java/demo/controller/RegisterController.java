// Copyright Fairfax Media 2014

package demo.controller;

import demo.model.User;
import demo.model.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ke.yang on 26/02/2016.
 */
@RestController
public class RegisterController extends  UserAbstractController{

    @RequestMapping(path = "/register", method = {RequestMethod.PUT}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AbstractController.Message createUser(@RequestBody UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) {
        userDAO.save(new User(userDTO));
        return OK;
    }

}
