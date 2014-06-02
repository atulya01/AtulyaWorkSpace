package implementation;

import aliensAndHumans.Alien;
import utility.UtilityClass;

/**
 * Impl Class - created to keep all implementation methods related to the application.
 * @author Atulya Rastogi
 *
 */
public class Impl {

	//Method- written to display first question to user and capture user response. It returns String value of user entered response.
	public static String getNewEntryQues(){
		System.out.println();
		System.out.println("Do you want to make a new entry? [Y / N] ");
		String enteredValue=UtilityClass.getScannerString();			
		return enteredValue;
	}
	
	//Method- written to close the application. It returns true when the application is closed successfully.
	public static boolean closeApplication(){
		System.out.println("Leaving App");
		System.exit(0); 
		return true;	
	}
	
	//Method- written to display second question to user and capture user response. It returns String value of entered response.
	public static String getFileExported(){
		System.out.println("Do you want to export these details into a text file/PDF file/No? [PDF/Text/N]");
		String extraxctResponse=UtilityClass.getScannerString();	
		return extraxctResponse;
	}
	
	//Method- written to display all entry questions for an alien. It captures all responses and creates an alien object by invoking constructor of Alien Class.
	//Parameters - It takes Alien type of reference and returned created Alien Object.
	public static Alien getAllEntryQues(Alien alienObj){
		System.out.println();
		System.out.println("Enter Code Name of Alien");
		String nameCode = UtilityClass.getScannerString();
		System.out.println();
		System.out.println("Enter Blood Color of Alien");
		String bloodColor = UtilityClass.getScannerString();
		System.out.println();
		System.out.println("Enter Number of Antennas of Alien");
		String antennas = UtilityClass.getScannerString();
		System.out.println();
		System.out.println("Enter Number of Legs of Alien");
		String legs = UtilityClass.getScannerString();
		System.out.println();
		System.out.println("Enter Home Planet of Alien");
		String planet = UtilityClass.getScannerString();
		System.out.println();
	
		alienObj = new Alien(nameCode,bloodColor,antennas,legs,planet);
		return alienObj;
	}
	
}
