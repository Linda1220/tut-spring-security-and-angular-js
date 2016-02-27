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

        private boolean duplicatedUsername;
        private String errorMessage;

        Message(boolean duplicatedUsername, String errorMessage) {
            this.duplicatedUsername = duplicatedUsername;
            this.errorMessage = errorMessage;
        }

        public boolean isDuplicatedUsername() {
            return duplicatedUsername;
        }

        public void setDuplicatedUsername(boolean duplicatedUsername) {
            this.duplicatedUsername = duplicatedUsername;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    private Message duplicatedUsername = new Message(true, "username already existed");
    private Message validUsername = new Message(false, "username valid");

    private static class DuplicateUsernameRequest {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/validator/duplicatedUsername", method = {RequestMethod.POST})
    public String duplicateUsername(@RequestBody DuplicateUsernameRequest duplicateUsernameRequest) {
        User user = userDAO.findByUsername(duplicateUsernameRequest.getUsername());
        if (user != null) {
            return gson.toJson(duplicatedUsername);
        }

        return gson.toJson(validUsername);
    }
}
