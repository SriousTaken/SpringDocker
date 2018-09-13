package applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import util.CommandExecutioner;

@SpringBootApplication
@RestController
public class Application {
	@RequestMapping("/")
    public String home() {
        return "Hello Docker World TEST 1";
    }
   
    @RequestMapping("/ping")
    public String ping() {
    	return "Ping2! ";
    }
    
    @RequestMapping("/command")
    public String command() {
    	CommandExecutioner commandExecutioner = new CommandExecutioner("ls", System.getProperty("user.home"));
    	return commandExecutioner.execute();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}