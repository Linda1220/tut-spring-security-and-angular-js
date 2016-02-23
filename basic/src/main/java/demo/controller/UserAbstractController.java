package demo.controller;

import demo.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Linda on 22/02/16.
 */
public class UserAbstractController extends AbstractController {
    @Autowired
    protected UserDAO userDAO;
}
