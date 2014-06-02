package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import aliensAndHumans.Alien;
import applicationFlow.FlowClass;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class UtilityClass {
	String dataFile;
	
	//Created to export an alien object's data into a text file. It returns true if file exported to TEXT successfully.
	//Parameter - It takes File Object and Alien Object as parameter.
		public static boolean exportText(String nameOfFile, Alien alienObj){
				
			BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new FileWriter(nameOfFile+".txt"));
					writer.write("Code name of alien is : " + alienObj.getAlienCode());writer.newLine();
		        	writer.write("Blood Color of alien is : " + alienObj.getAlienBloodColor());writer.newLine();
		        	writer.write("Number of Antennas of alien are : " + alienObj.getAlienAntennas());writer.newLine();
		        	writer.write("Number of Legs of alien are: " + alienObj.getAlienLegs());writer.newLine();
		        	writer.write("Home Planet of alien is : " + alienObj.getAlienHomePlanet());writer.newLine();
		        	writer.newLine();
		        	writer.newLine();
		        	writer.newLine();
		        	writer.newLine();
				} 
				catch (IOException e) {
		        System.err.println(e);
				} 
				finally {
		        if (writer != null) {
		            try {
		                writer.close();
		            } catch (IOException e) {
		                System.err.println(e);
		            }
		        }
		    }
		    return true;
		}
		
		//Created to export an alien object's data into a PDF file. It returns true if file exported to PDF successfully.
		//Parameter - It takes File Object as parameter.
		public static  boolean exportPdf(File file){
			FileInputStream iStream=null;  
			DataInputStream in=null;  
			InputStreamReader is=null;  
			BufferedReader br=null;  
			  
			try {  
			      Document pdfDoc = new Document();  
			        
			      String text_file_name =FlowClass.filename+".pdf";  
			      PdfWriter writer=PdfWriter.getInstance(pdfDoc,new FileOutputStream(text_file_name));  
			      pdfDoc.open();  
			      pdfDoc.setMarginMirroring(true);  
			      pdfDoc.setMargins(36, 72, 108,180);  
			      pdfDoc.topMargin();  
			      Font normal_font = new Font();  
			      Font bold_font = new Font();  
			      bold_font.setStyle(Font.BOLD);  
			      bold_font.setSize(10);  
			      normal_font.setStyle(Font.NORMAL);  
			      normal_font.setSize(10);  
			      pdfDoc.add(new Paragraph("\n"));  
			      	
			      if(file.exists())  
			    	{  
			    	  iStream = new FileInputStream(file);  
			    	  in = new DataInputStream(iStream);  
			    	  is=new InputStreamReader(in);  
			    	  br = new BufferedReader(is);  
			    	  String strLine;  
			    	  	while ((strLine = br.readLine()) != null)   {  
			    	  		Paragraph para =new Paragraph(strLine+"\n",normal_font);  
			    	  		para.setAlignment(Element.ALIGN_JUSTIFIED);  
			    	  		pdfDoc.add(para);  
			    	  	}  
			    	}     
			    else  
			    {  
			     System.out.println("file does not exist");  
			     return false;  
			    }  
			    pdfDoc.close();   
			  }  
			    
			  catch(Exception e)  
			  {  
			   System.out.println("FileUtility.covertEmailToPDF(): exception = " + e.getMessage());  
			  }  
			  finally  
			  {  
			     
			    try {  
			     if(br!=null)  
			     {  
			     br.close();  
			     }  
			     if(is!=null)  
			     {  
			     is.close();  
			     }  
			     if(in!=null)  
			     {  
			     in.close();  
			     }  
			     if(iStream!=null)  
			     {  
			      iStream.close();  
			     }  
			    } catch (IOException e) {  
			     // TODO Auto-generated catch block  
			     e.printStackTrace();  
			    }  
			     
			  }  
			  return true;  
		}

		//Method - written to get entered values from console. It returns String which is the value entered by the user.
		public static String getScannerString(){
			String response=null;
			Scanner scanner = new Scanner(System.in);
			response = scanner.nextLine();
			return response;
		}
		
}
