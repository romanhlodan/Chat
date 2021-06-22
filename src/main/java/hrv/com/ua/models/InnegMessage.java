package hrv.com.ua.models;

public class InnegMessage {
    private String msg;

    public InnegMessage() {
    }

    public InnegMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "InnegMessage{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
