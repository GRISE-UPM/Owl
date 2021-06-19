package es.upm.grise.owl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class OwlTest {


	@Rule 
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	/*

	@Test 
	public void Return() throws FileNotFoundException { 
		String fullText = new String(); 
		File file = new File("resources/help/TopLevelHelp.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) 
			fullText = fullText + scanner.nextLine() + "\n"; 
		scanner.close(); 
		assertEquals("hello world", systemOutRule.getLog()); 
	}
	
	@Test 
	public void Return() throws FileNotFoundException { 
		String fullText = new String(); 
		File file = new File("resources/help/TopLevelHelp.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) 
			fullText = fullText + scanner.nextLine() + "\n"; 
		scanner.close(); 
		assertEquals("hello world", systemOutRule.getLog()); 
	}
	
	*/
	
	
}
