package applications.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import literals.Literals;

/**
 * Provides all Spring web application sites related to health checks
 * @author Kevin Kassin
 */
@RestController
public class HealthCheckController {
	
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
}
