package es.upm.grise.owl;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class OwlParameterProcessorTest {
	
	private OwlParameterProcessor owlParameterProcessor;
	private Logger logger;
	
	@Before
	public void setUp() {
		logger = mock(Logger.class);
		owlParameterProcessor = new OwlParameterProcessor(logger);
	}
	
	@Test
	public void no_Class_Specified_In_Command_Line() {
		String pluginName = "";
		InOrder inOrder = inOrder(logger);
		owlParameterProcessor.invokePlugin(pluginName, null);
		inOrder.verify(logger).info("Searching for plugin " + pluginName);
		inOrder.verify(logger).error("Class " + pluginName + " not found");
	}
	
	@Test
	public void non_Existing_Class_Specified_In_CommandLine() {
		String pluginName = "this.is.not.a.valid.Class";
		InOrder inOrder = inOrder(logger);
		owlParameterProcessor.invokePlugin(pluginName, null);
		inOrder.verify(logger).info("Searching for plugin " + pluginName);
		inOrder.verify(logger).error("Class " + pluginName + " not found");
	}
	
	@Test
	// Owl is an internal class, not plugin
	public void class_Specified_In_Command_Line_But_Not_A_Plugin() {
		String pluginName = "es.upm.grise.owl.Owl";
		InOrder inOrder = inOrder(logger);
		owlParameterProcessor.invokePlugin(pluginName, null);
		inOrder.verify(logger).info("Searching for plugin " + pluginName);
		inOrder.verify(logger).error("Plugin " + pluginName + " not found");
	}
	
	@Test
	// UserManager is an internal plugin
	public void plugin_Specified_In_Command_Line() {
		String pluginName = "es.upm.grise.owl.plugin.UserManager";
		InOrder inOrder = inOrder(logger);
		owlParameterProcessor.invokePlugin(pluginName, null);
		inOrder.verify(logger).info("Searching for plugin " + pluginName);
		inOrder.verify(logger).info("Plugin " + pluginName + " found");
	}
}
