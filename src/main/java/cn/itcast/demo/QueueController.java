package cn.itcast.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
	
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	
	@RequestMapping("/send")
	public void send(String text) {
		jmsMessagingTemplate.convertAndSend("itcast", text);
	}
	
	
	@RequestMapping("/sendmap")
	public void sendMap(String text) {
		Map map=new HashMap<>(); 
		  map.put("mobile", "17864111205"); 
		  map.put("template_code", "SMS_123738873"); 
		  map.put("sign_name", "黑马品优购用户注册模版");
		  map.put("param", "{\"code\":\"123456\"}");
		jmsMessagingTemplate.convertAndSend("sms", map);
	}

}
