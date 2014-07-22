import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
																		
						for (int i = 0; i < currencyRateNodeList.getLength(); i++) {
							
							Element currencyElement = (Element) currencyRateNodeList.item(i);
							
							CurrencyMainClass c = new CurrencyMainClass();
							c.setCurrency(currencyElement.getAttribute("currency"));
							c.setRate(currencyElement.getAttribute("rate"));
							
							System.out.println(c.getCurrency() +" / EUR :  " + c.getRate());
							}
						
					}
			    
			 		if (urlConnection !=null) {
			 			
			 			urlConnection.disconnect();
			 		}
						
			      }
			      
	}
	

		