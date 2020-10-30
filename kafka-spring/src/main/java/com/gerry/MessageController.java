package com.gerry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("send/{msg}")
    public String send(@PathVariable("msg") String msg){
    	System.out.println("----发送消息："+msg+"----");
        kafkaTemplate.send("springboottopic", msg);
        return "----发送消息："+msg+"----";
    }
}
