package literals;

import java.util.HashMap;
import java.util.Map;

public class Literals {
	
	public final String App_ID = "Spring1";

	public final String CLUSTER_IP = "192.168.99.100";
	
	public final String PORT = "30125";
	
	public final Map<String, String> PORTS_COMM_PARTNERS = initialize_ports_comm_partners();
	
	private Map<String, String> initialize_ports_comm_partners() {
		Map<String, String> port_comm_partners = new HashMap<String, String>();
		//begin set values
		port_comm_partners.put("Spring2", "30126");
		//end set values
		return port_comm_partners;
	}
	
}
