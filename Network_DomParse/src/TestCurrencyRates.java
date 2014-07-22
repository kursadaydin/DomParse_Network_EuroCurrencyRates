import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class TestCurrencyRates {
	
	public static void main(String[] args) throws Exception{
				
				HttpURLConnection  urlConnection=null;
			     
			      URL url = new URL( "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml" );

			      urlConnection = (HttpURLConnection) url.openConnection();
			    
			      int sonucKodu = urlConnection.getResponseCode() ;
			      
			      if (sonucKodu==HttpURLConnection.HTTP_OK) {
			    	  System.out.println("Ýþlem Baþarýlý");
			    	 
			    	  	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
						Document document = docBuilder.parse(url.openStream());
						document.getDocumentElement().normalize();
						
						Element firstCube =(Element) document.getElementsByTagName("Cube").item(0);
						Element secondCube =(Element) firstCube.getElementsByTagName("Cube").item(0);
						NodeList currencyRateNodeList = secondCube.getElementsByTagName("Cube");
						
						File dosya = new File("C:\\Users\\Kürþad\\Desktop\\text.txt");

						Calendar cal = Calendar.getInstance();
				    	cal.getTime();
				    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				    	String time = sdf.format(cal.getTime());
				    	
				    	
				    	ArrayList<String> dizi_total = new ArrayList<String>();
						dizi_total.add("DOSYANIN ÇEKÝM TARÝHÝ : " +time);
																		
						for (int i = 0; i < currencyRateNodeList.getLength(); i++) {
							
							Element currencyElement = (Element) currencyRateNodeList.item(i);
							
							String currencyString =currencyElement.getAttribute("currency");
							String rateString =currencyElement.getAttribute("rate");
							
							dizi_total.add(currencyString+" / EUR :  "+ rateString);
													
							String line  = currencyString +" / EUR :  " +rateString;
							
							System.out.println(line);
							
							FileUtils.writeLines(dosya,dizi_total);
							
							}
						}
			    
			 		if (urlConnection !=null) {
			 			
			 			urlConnection.disconnect();
			 		}
						
			      }
			      
	}
	

		