package applicationFlow;

import implementation.Impl;
import java.io.File;
import aliensAndHumans.Alien;
import utility.UtilityClass;

/**
 * Class - created to keep all the methods related to flow control of the application.
 * @author Atulya Rastogi
 *
 */
public class FlowClass {
	
	public static String filename;
	static boolean deleteTxt=false;
	static Alien alien,alienObjectCreated;
	static boolean isEntryCreated,isPDFCreated,isTextCreated;
	static boolean isApplicationClosed;

	
	//This method includes method calls for all implementation methods. 
	//In this method, the value returned by each implementation method is analyzed in other methods for condition check.
	public static void mainFlow(){
		String firstResponse=Impl.getNewEntryQues();
	
		firstQuestionConditions(firstResponse);
	
		String secondResponse=Impl.getFileExported();
	
		exportQuestionConditions(secondResponse,alienObjectCreated);
	
		mainFlow(); //recursive call
		
	}
	
	
	//This method is written to check the response of user for first Question, based on response next implementation method is called.
	//Parameters - It takes response of first question as parameter.
	public static void firstQuestionConditions(String responseOfFirstQues){
		while((responseOfFirstQues.equalsIgnoreCase("Y"))){
			alienObjectCreated=Impl.getAllEntryQues(alien);
			if(alienObjectCreated !=null)
				isEntryCreated=true;
		break;
		}
		while(responseOfFirstQues.equalsIgnoreCase("N")){
			isApplicationClosed=Impl.closeApplication();	
			break;
		}
		while((!responseOfFirstQues.equalsIgnoreCase("n")) && (!responseOfFirstQues.equalsIgnoreCase("y"))){
			if(isEntryCreated==false && isApplicationClosed==false)
			System.out.println("Entered response is invalid...  Please give a valid response");
			String str=UtilityClass.getScannerString();
			firstQuestionConditions(str);
		}
		
		while(responseOfFirstQues==null){
			break;
		}
	}
	
	//This method is written to check the response of user for second Question, based on response next implementation method for exporting of data is called.
	//Parameters - It takes response of second question and Alien reference as parameter.
	public static void exportQuestionConditions(String responseOfSecondQues, Alien alienObjUpdated){
		filename= alienObjUpdated.getAlienCode();

		while((responseOfSecondQues.equalsIgnoreCase("PDF"))){
			boolean isCreatedTxt= UtilityClass.exportText(filename,alienObjUpdated);
			if(isCreatedTxt)
				deleteTxt = true;
				boolean isPDFCreated= UtilityClass.exportPdf(new File(filename+".txt"));
			if(deleteTxt == true && isPDFCreated == true)
			{
				new File(filename +".txt").delete();
				System.out.println("PDF File created in the current folder.");
			}
			break;
		}
		while(responseOfSecondQues.equalsIgnoreCase("Text")){
			isTextCreated=UtilityClass.exportText(filename,alienObjUpdated);
			System.out.println("Text file created in the current folder.");
			break;
		}
		while(responseOfSecondQues.equalsIgnoreCase("n")){
			break;
		}
		while(!responseOfSecondQues.equalsIgnoreCase("PDF") && !responseOfSecondQues.equalsIgnoreCase("text") && !responseOfSecondQues.equalsIgnoreCase("n")){
			System.out.println("Entered response is invalid...  Please give a valid response");
			String str=UtilityClass.getScannerString();
			exportQuestionConditions(str,alienObjUpdated);
			break;
		}
		while(responseOfSecondQues==null){
			break;
		}
		
		
	}
	

	

	
	
}
