package es.upm.grise.owl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Owl {

	private static final Logger logger = LogManager.getLogger(Owl.class);
	private static final OwlParameterProcessor owlParameterProcessor = new OwlParameterProcessor(logger);
	
	public static void main( String[] args )  {

		PropertyConfigurator.configure("resources/log4j.properties");
		
		// Process command line
		String pluginName = args[0];
		
		// When the pluginName contains a dot ".", we assume it is fully qualified
		if(!pluginName.contains("."))
			pluginName = "es.upm.grise.owl.plugin." + pluginName;
		
		// Everything after the plugin is the action that the plugin should perform
		String [] action = new String[args.length - 1];
		System.arraycopy(args, 1, action, 0, args.length - 1);
		owlParameterProcessor.invokePlugin(pluginName, action);
	}
}
