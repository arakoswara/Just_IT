package travel.ezy.campuran;

import java.util.List;

public class Response {
    public Boolean error;
    public List<Message> message = null;
    public Integer code;

    public class Message {

        public String name;
        public String address;
        public String lattitude;
        public String longitude;

    }
}
