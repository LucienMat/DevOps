package fr.takima.training.simpleapi.controller;

//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/", produces={APPLICATION_JSON_VALUE})	
@CrossOrigin
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/")	
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		 name = "Guth";
	     return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	class Greeting {

       private final long id;
       private final String content;

       public Greeting(long id, String content) {
           this.id = id;
           this.content = content;
       }

       public long getId() {
           return id;
       }

       public String getContent() {
           return content;
       }
       
       @Override
	   public String toString() {
    	   
	   		StringJoiner sj = new StringJoiner(", ", "\n    Greeting [", "]");
	   		sj.add(Long.toString(getId())).add("Content=" + getContent());
	   		
	   		return sj.toString();
	   }
       
       
	}

	

}
