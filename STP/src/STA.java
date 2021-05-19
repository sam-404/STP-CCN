
public class STA {

	public class Port {
		public int portCost;
		public boolean rootPort = false;
		public boolean desgPort = false;
		public boolean blockPort = false;

		public Port(int portCost) {
			this.portCost = portCost;

		}
		
		public int getPortCost() {
			return portCost;
		}

		public void setRP(boolean RP) {
			this.rootPort = RP;

		}

		public void setDP(boolean DP) {
			this.desgPort = DP;

		}

		public void setBP(boolean BP) {
			this.blockPort = BP;

		}

		public String getPorts() {
			return "Root Port " + rootPort + "," + "Designated Port: " + desgPort + "," + "Blocked Port " + blockPort;
		}

	}

	public class Switch {
		// we are assuming all switches have the same default priority value so the MAC
		// addresses
		// of each switch will be compared and the one with the smallest one will be the
		// root bridge

		public int bridgeID;
		public Port port1;
		public Port port2;

		public Switch(int bridgeID) {
			this.bridgeID = bridgeID;
		}
		
		public void setPort1(int portCost) {
			Port port1 = new Port(portCost);
			this.port1 = port1;
				
		}
		
		public void setPort2(int portCost) {
			Port port2 = new Port(portCost);
			this.port2 = port2;
				
		}

	}

	public STA() {
		Switch switch1 = new Switch(1111); // root bridge because it has the smallest bridgeID
		Switch switch2 = new Switch(2222);
		Switch switch3 = new Switch(3333);
		
		switch1.setPort1(4);
		switch1.setPort2(12);
		
		switch2.setPort1(2);
		switch2.setPort2(15);
		
		switch3.setPort1(3);
		switch3.setPort2(5);
		
		// the ports of a root bridge will be designated ports
		switch1.port1.setDP(true);
		switch1.port2.setDP(true);
	
		
		if (switch2.port1.getPortCost() < switch2.port2.getPortCost()) {
			switch2.port1.setRP(true);
			switch2.port2.setDP(true);
		}
		else {
			switch2.port2.setRP(true);
			switch2.port1.setDP(true);
		}
		
		if (switch3.port1.getPortCost() < switch3.port2.getPortCost()) {
			switch3.port1.setRP(true);
			switch3.port2.setBP(true);
		}
		else {
			switch3.port2.setRP(true);
			switch3.port1.setBP(true);
		}
		
		System.out.println("Switch 1 (Root Bridge) Ports: Port 1 " + switch1.port1.getPorts() + "|" + "Port 2: " + switch1.port2.getPorts());
		System.out.println("Switch 2 Ports: Port 1 " + switch2.port1.getPorts() + "|" + "Port 2: " + switch2.port2.getPorts());
		System.out.println("Switch 3 Ports: Port 1 " + switch3.port1.getPorts() + "|" + "Port 2: " + switch3.port2.getPorts());
		
		
	}
	

	public static void main(String[] args) {
		STA sta = new STA();
		

	}

}
