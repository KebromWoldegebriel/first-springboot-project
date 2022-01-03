package io.kebrom.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Jason Response
@RestController
public class HelloController {
	
	//maps only to GET methods by default
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

}
