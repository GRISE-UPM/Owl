package es.upm.grise.owl.plugin;

import org.basex.core.cmd.XQuery;

public interface Plugin {
	
	void perform(String[] action);
	
	Boolean Add(String addres,String EmailAddress, String id, String name,String role);
	Boolean Update(String addres,String EmailAddress, String id, String name,String role);
	Boolean Remove(String id);
	Boolean GetUser(String id);
	Boolean GetFiles(String name);
}