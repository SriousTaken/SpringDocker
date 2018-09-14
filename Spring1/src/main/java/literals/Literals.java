package literals;

import java.util.HashMap;
import java.util.Map;

/**
 * Application literals, for example IDs, URI parts, ports...
 * @author Kevin Kassin
 */
public class Literals {
	
	/**
	 * The identifier of this Spring web application
	 */
	public final String App_ID = "Spring1";

	/**
	 * The IP of the cluster the docker running this Spring web application
	 */
	public final String CLUSTER_IP = "192.168.99.100";
	
	/**
	 * The port of the docker running this Spring web application
	 */
	public final String PORT = "30125";
	
	/**
	 * The ports of other dockers running Spring web applications to communicate to, mapped by their identifiers
	 */
	public final Map<String, String> PORTS_COMM_PARTNERS = initialize_ports_comm_partners();
	
	/**
	 * Initializes the map of ports of other dockers running Spring web applications to communicate to
	 * @return the map of ports of other dockers running Spring web applications to communicate to
	 */
	private Map<String, String> initialize_ports_comm_partners() {
		Map<String, String> port_comm_partners = new HashMap<String, String>();
		//begin: set values
		port_comm_partners.put("Spring2", "30126");
		//end: set values
		return port_comm_partners;
	}
	
}
