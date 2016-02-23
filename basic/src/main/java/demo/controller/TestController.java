package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Linda on 22/02/16.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "users-overview";
    }
}
