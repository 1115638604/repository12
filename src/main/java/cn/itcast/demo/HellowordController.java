package cn.itcast.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowordController {
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping("/info")
	public String Demo() {
		
		return "helloword111"+env.getProperty("url");
	}

}
