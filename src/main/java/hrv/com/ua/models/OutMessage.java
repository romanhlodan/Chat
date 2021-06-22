package hrv.com.ua.models;

public class OutMessage {
    private String outMsg;

    public OutMessage() {
    }

    public OutMessage(String outMsg) {
        this.outMsg = outMsg;
    }

    public String getOutMsg() {
        return outMsg;
    }

    public void setOutMsg(String outMsg) {
        this.outMsg = outMsg;
    }

    @Override
    public String toString() {
        return "OutMessage{" +
                "outMsg='" + outMsg + '\'' +
                '}';
    }
}
