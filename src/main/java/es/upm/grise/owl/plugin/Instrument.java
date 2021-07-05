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
						case "tasks"		: query = "for $x in doc('resources/xml/SEDL-instance.xml')//tasks return json:serialize($x, map { 'format': 'jsonml' })";
										  System.out.println(new XQuery(query).execute(context));
										  break;
						case "files"		: break;
						default			: // Error message
										  break;
					}
					
				case "get"	  :
					switch (action[1]) {
						case "task"		: break;
						case "file"		: break;
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
}
