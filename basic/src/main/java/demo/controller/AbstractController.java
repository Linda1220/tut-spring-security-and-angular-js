package demo.controller;

/**
 * Created by Linda on 21/02/16.
 */
public class AbstractController {
    public Message OK = new Message("OK");
    public Message FAILED = new Message("FAILED");

    public static class Message {
        public String status;

        public Object content;

        public Message(String status) {
            this.status = status;
        }

        public Message(String status, Object content) {
            this.status = status;
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }
    }
}
