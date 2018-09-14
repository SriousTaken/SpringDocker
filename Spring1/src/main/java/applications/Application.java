package applications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import literals.Literals;
import util.CommandExecutioner;

@SpringBootApplication
@RestController
public class Application {
	
	/**
	 * Literals of this application, for example, IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	/**
	 * List of URIs of communication partners
	 */
	final List<String> COMM_PARTNERS = initialize_comm_partners();
	
	/**
	 * Builds the list of URIs of communication partners
	 * @return
	 */
	public List<String> initialize_comm_partners() {
		List<String> comm_partners = new ArrayList<String>();
		comm_partners.add("http://" + literals.CLUSTER_IP+ ":" + literals.PORTS_COMM_PARTNERS.get("Spring2") + "/pong");
		return comm_partners;
	} 
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@RequestMapping("/")
    public String home() {
        return "Hello Docker World TEST 1";
    }
   
    @RequestMapping("/ping")
    public String ping() {
    	RestTemplate restTemplate = new RestTemplate();
    	String result = "";
    	for(String comm_partner : COMM_PARTNERS) {
    		result = restTemplate.getForObject(comm_partner, String.class);
    	}	
    	return result;
    }
    
    @RequestMapping("/command")
    public String command() {
    	CommandExecutioner commandExecutioner = new CommandExecutioner("ls", System.getProperty("user.home"));
    	return commandExecutioner.execute();
    }

    
}