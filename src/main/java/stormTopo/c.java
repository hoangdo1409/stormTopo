package stormTopo;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;

public class c {
	public static void main(String[] args) throws Exception {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("My-First_Spout", new b());
		builder.setBolt("My-First-Bolt", new a()).shuffleGrouping("My-first_Spout");
		
		
		Config config = new Config();
		config.setDebug(true);
		
		LocalCluster cluster = new LocalCluster();
		try {
			cluster.submitTopology("My-First-Topo", config, builder.createTopology());
			Thread.sleep(1000);}
		finally {
			cluster.shutdown();}
	}
}
