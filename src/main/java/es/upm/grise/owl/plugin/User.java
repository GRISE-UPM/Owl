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
	 for (String s:action) {
		 System.out.println(s);
	 }
		try {
			switch(action[0]) {
				case "list"   : query = "for $x in doc('resources/xml/SEDL-instance.xml')//person return json:serialize($x, map { 'format': 'jsonml' })";
								System.out.println(new XQuery(query).execute(context));
								break;
				case "add"	  : Add(action[1], action[2],action[3],action[4],action[5]);

								break;
				case "remove" : Remove(action[1]);
								break;
				case "get"    : Remove(action[1]);
								break;
					
				case "update" : Update(action[1], action[2],action[3],action[4],action[5]);  
								break;
  }
		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public Boolean Add(String addres,String EmailAddress, String id, String name,String role) {
		// TODO Auto-generated method stub
		String query = "";
		try {
			query = "copy $d := doc('resources/xml/SEDL-instance.xml')" + "modify(insert node <person address=\""+addres+"\" email=\""+	EmailAddress+"\" id=\""+id+"\" name=\""+name+"\" role=\""+role+"\"/>  into $d//people)" +"return fn:put($d, 'resources/xml/SEDL-instance.xml')";
			System.out.println(new XQuery(query).execute(context));
			return true;
			} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}	
	@Override
	public Boolean Update(String addres,String EmailAddress, String id, String name,String role) {
		// TODO Auto-generated method stub
		String query = "";
		try {
			   query = "copy $d := doc('resources/xml/SEDL-instance.xml')" + "modify(replace value of node $d//people/person[@id='"+id+"'] with '<person address=\""+addres+"\" email=\""+EmailAddress+"\" id=\""+id+"\" name=\""+name+"\" role=\""+role+"\"/>' )" +"return fn:put($d, 'resources/xml/SEDL-instance.xml')";
				System.out.println(new XQuery(query).execute(context)); 
			return true;
			} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public Boolean Remove(String id){
		// TODO Auto-generated method stub
		String query = "";
		try {
			query = "copy $d := doc('resources/xml/SEDL-instance.xml')" + "modify(delete node $d//people/person[@id='"+id+"'] )" +"return fn:put($d, 'resources/xml/SEDL-instance.xml')";
			System.out.println(new XQuery(query).execute(context)); 
			return true;
			} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public Boolean GetUser(String id){
		// TODO Auto-generated method stub
		String query = "";
		try {
			query = "for $x in doc('resources/xml/SEDL-instance.xml')//people/person[@id='"+id+"'] return json:serialize($x, map { 'format': 'jsonml' })";
			System.out.println(new XQuery(query).execute(context));
			return true;
			} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}



	@Override
	public Boolean GetFiles(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
