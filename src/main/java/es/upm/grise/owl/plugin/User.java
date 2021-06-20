package es.upm.grise.owl.plugin;

import org.basex.core.*;
import org.basex.core.cmd.*;

@Owlo
class User implements Plugin {

	public User() {
		// I guess we could do checks here
	}

	static Context context = new Context();

	public void perform(String [] action) {
		String query = "";

		try {
			switch(action[0]) {
				case "list"   : query = "for $x in doc('resources/xml/SEDL-instance.xml')//person return json:serialize($x, map { 'format': 'jsonml' })";
								System.out.println(new XQuery(query).execute(context));
								break;
				case "add"	  : ;
				case "remove" : ;
				case "get"    : ;
				case "update" : ;
			}	
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
