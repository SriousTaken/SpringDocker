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

/**
 * Defines a Spring web application using Rest calls
 * @author Kevin Kassin
 */
@SpringBootApplication
@RestController
public class Application {
	
	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	/**
	 * List of URIs of communication partners
	 */
	final List<String> COMM_PARTNERS = initialize_comm_partners();
	
	/**
	 * Builds the list of URIs of communication partners
	 * @return list of URIs of communication partners
	 */
	public List<String> initialize_comm_partners() {
		List<String> comm_partners = new ArrayList<String>();
		comm_partners.add("http://" + literals.CLUSTER_IP+ ":" + literals.PORTS_COMM_PARTNERS.get("Spring2") + "/pong");
		return comm_partners;
	} 

	/**
	 * Runs the Spring web application
	 */
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	/**
	 * Defines the index page of the Spring web application
	 * @return
	 */
	@RequestMapping("/")
    public String index() {
        String uri = "http://" + literals.CLUSTER_IP+ ":" + literals.PORT;
		return "<h1>Spring Application on Docker</h1>"
        		+ "This is Spring Application " + literals.App_ID + "<br>"
        		+ "<ul>" 
        		+ "<li><a href=" + uri + "/ping>Ping Pong Scenario</a></li>" 
        		+ "<li><a href=" + uri + "/alive>Alive Checking Scenario</a></li>"
        		+ "<li>Command Scenario <ul>"
        			+ "<li><a href=" + uri + "/command_fix>Fix command: ls</a></li>"
        			+ "<li><a href=\" + uri + \"/command_input>Command input</a></li>"
        			+ "</ul>"
        		+"<ul>";
    }
  
	/**
	 * Pings to the Spring web application Spring2 to get a pong answer
	 * @return String representing the answer of Spring web application Spring2
	 */
    @RequestMapping("/ping")
    public String ping() {
    	String pingPongPartner = "http://" + literals.CLUSTER_IP+ ":" + literals.PORTS_COMM_PARTNERS.get("Spring2") + "/pong";
    	RestTemplate restTemplate = new RestTemplate();
    	String result = "Spring2 says: " + restTemplate.getForObject(pingPongPartner, String.class);	
    	return result;
    }
    
    /**
     * Executes a ls command on the docker the Spring web application is running on
     * @return String representing the result of the ls command
     */
    @RequestMapping("/command_fix")
    public String command() {
    	CommandExecutioner commandExecutioner = new CommandExecutioner("ls", System.getProperty("user.home"));
    	return commandExecutioner.execute();
    }
}