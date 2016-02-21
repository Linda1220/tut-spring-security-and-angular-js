package demo.controller;

/**
 * Created by Linda on 21/02/16.
 */
public class AbstractController {
    Message OK = new Message("OK");
    Message FAILED = new Message("FAILED");

    public class Message {
        public String status;

        public Message(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
