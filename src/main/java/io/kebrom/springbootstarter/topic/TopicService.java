package io.kebrom.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//this annotation change a class into business service 
//basically business services are a singleton class that will be created and injected 
//by spring once and will be  to whoever that need them. They helps avoid created instance of class 
//again and again 

@Service
public class TopicService {
	
	private List<Topic> topics  = new ArrayList<>(Arrays.asList(
			                     new Topic("spring","Spring Framework", "Spring Framework Description"),
			                     new Topic("java","Core Java", "Core Java Description"),
			                     new Topic("javascript","JavaScript", "JavaScript Description")
			                       ));
	
	public List<Topic> getAllTopics() {
			return topics;
	}
	
	public Topic getTopic(String id) {
		// dont worry about this code for now. Learn it later 
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
