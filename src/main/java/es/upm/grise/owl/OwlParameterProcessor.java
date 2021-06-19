package es.upm.grise.owl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import es.upm.grise.owl.plugin.Owlo;
import es.upm.grise.owl.plugin.Plugin;

public class OwlParameterProcessor {
	
	Logger logger;
	
	OwlParameterProcessor(Logger logger) {
		this.logger = logger;
	}
	
	public void invokePlugin(String pluginName, String[] action) {
		//TODO: Is it enough to read from the classpath?
		// We try to find the class and verify it is a plugin
		Class<?> pojo;
		logger.info("Searching for plugin " + pluginName);

		try {
			pojo = Class.forName(pluginName);
			if(pojo.isAnnotationPresent(Owlo.class)) {
				logger.info("Plugin " + pluginName + " found");
				
				// Give the plugin control
				Constructor<?> pluginConstructor = pojo.getConstructor();
				pluginConstructor.setAccessible(true);
				Plugin plugin = (Plugin) pluginConstructor.newInstance();
				plugin.perform(action);
				
			} else {
				logger.error("Plugin " + pluginName + " not found");
			}

		} catch (ClassNotFoundException e) {
			logger.error("Class " + pluginName + " not found"); 
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
