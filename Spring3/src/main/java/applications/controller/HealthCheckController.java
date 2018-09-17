package applications.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides all Spring web application sites related to health checks
 * @author Kevin Kassin
 */
@RestController
public class HealthCheckController {
	
	/**
	 * Provides the a simple "pong" message to check for availability of the docker running the Springw eb application
	 * @return
	 */
	 @RequestMapping(value="/pong", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	 public String pong() {
		 return "Pong!";
	 }
}
