package literals;

import java.util.HashMap;
import java.util.Map;

public class Literals {

	String clusterIP = "192.168.99.100";
	
	String port = "30126";
	
	Map<String, String> port_comm_partners = initialize_port_comm_partners();
	
	private Map<String, String> initialize_port_comm_partners() {
		Map<String, String> port_comm_partners = new HashMap<String, String>();
		//begin set values
		port_comm_partners.put("Spring1", "30125");
		//end set values
		return port_comm_partners;
	}
	
}
