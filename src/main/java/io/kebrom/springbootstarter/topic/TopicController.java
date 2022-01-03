package io.kebrom.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//this annotation changes this class to request controller AKA Rest API 
@RestController
public class TopicController {
	
	
	@Autowired
	private TopicService topicService;
	
	//Spring MV turns the returned List into Json obj
	//this annotation maps a request uri to a method 
	//by default @RequestMapping is a get method 
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	
	//{} will take any variable 
	//@PathVariable will make sure the id variable get passed 
	//to getTopic method
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	
	
	//by default the RequestMapping is a get method. 
	// Spring MV will scan for  @PostMapping(value="/topics")  and once it find it it will turn
	// the following Java method into a code that knows how to process a post request  
	//spring MVC is smart enough to turn the request json body into Topic instance object 
	// the way Spring MVC knows how to turn the json body into Topic instance object and pass it to 
	// the method is by using @RequestBody annotation 
	
	
	@PostMapping(value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
	

}
