package hrv.com.ua.controllers;

import hrv.com.ua.models.InnegMessage;
import hrv.com.ua.models.OutMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @MessageMapping("/message")
    @SendTo("/chanel/room")
    public OutMessage converter(InnegMessage message) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String format = dateFormat.format(date);
        OutMessage answer = new OutMessage(message.getMsg() + " : " + format);
        return answer;
    }
}
