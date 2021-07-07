package es.upm.grise.owl.plugin;

import org.basex.core.*;
import org.basex.core.cmd.*;

@Owlo
class Instrument implements Plugin {

	public Instrument() {
		// I guess we could do checks here
	}

	static Context context = new Context();

	public void perform(String [] action) {
		String query = "";

		try {
			switch(action[0]) {
			
				case "list"   : 
					switch (action[1]) {
						case "task"		: query = "for $x in doc('resources/xml/SEDL-instance.xml')//tasks return json:serialize($x, map { 'format': 'jsonml' })";
										  System.out.println(new XQuery(query).execute(context));
										  break;
						case "file"		: break;
						default			: // Error message
										  break;
					}
					
				case "get"	  :
					switch (action[1]) {
						case "task"		: break;
						case "file"		: GetFiles(action[2]);
										 break;
						default			: // Error message
										  break;
					}
					
				default: // Error message
						 break;	
				
			}	
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean GetFiles(String name){
		// TODO Auto-generated method stub
		String query = "";
		try {
			query = "for $x in doc('resources/xml/SEDL-instance.xml')//configurations/experimentalInputs[1]/inputDataSources/file[@name='"+name+"'] return json:serialize($x, map { 'format': 'jsonml' })";
			 System.out.println(new XQuery(query).execute(context));
			return true;
			} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	

	@Override
	public Boolean Add(String addres, String EmailAddress, String id, String name, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Update(String addres, String EmailAddress, String id, String name, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Remove(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean GetUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
