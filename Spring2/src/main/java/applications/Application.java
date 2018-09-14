package applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	@RequestMapping("/")
    public String home() {
        return "Hello Docker World TEST 2";
    }
    
    @RequestMapping(value="/pong", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public String pong() {
    	return "Pong!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }   
}
