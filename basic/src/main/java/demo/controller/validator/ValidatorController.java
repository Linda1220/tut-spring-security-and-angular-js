// Copyright Fairfax Media 2014

package demo.controller.validator;

import com.google.gson.Gson;
import demo.model.User;
import demo.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ke.yang on 27/02/2016.
 */
@RestController
public class ValidatorController {

    private Gson gson = new Gson();

    private static class Message {

        private boolean valid;
        private String errorMessage;

        public Message(boolean valid, String errorMessage) {
            this.valid = valid;
            this.errorMessage = errorMessage;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    private Message duplicatedUsername = new Message(false, "username already existed");
    private Message validUsername = new Message(true, "Valid Username");

    private Message existedEmail = new Message(false, "This email had been registerd,please change another or click the find account link");
    private Message validEmail = new Message(true, "Valid Email");

    private static class DuplicateRequest {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/validator/duplicatedUsername", method = {RequestMethod.POST})
    public String duplicateUsername(@RequestBody DuplicateRequest duplicateRequest) {
        User user = userDAO.findByUsername(duplicateRequest.getValue());
        if (user != null) {
            return gson.toJson(duplicatedUsername);
        }

        return gson.toJson(validUsername);
    }

    @RequestMapping(value = "/validator/existedEmail", method = {RequestMethod.POST})
    public String existedEmail(@RequestBody DuplicateRequest duplicateRequest) {
        User user = userDAO.findByEmail(duplicateRequest.getValue());
        if (user != null) {
            return gson.toJson(existedEmail);
        }

        return gson.toJson(validEmail);
    }


}
