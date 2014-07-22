import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class CurrencyMainClass {
	
	private String currencyList;
	private String rateList;
	
	public CurrencyMainClass() {
		super();
		}
	public String getCurrency() {
		return currencyList;
	}
	public void setCurrency(String currencyList) {
		this.currencyList = currencyList;
	}
	public String getRate() {
		return rateList;
	}
	public void setRate(String rateList) {
		this.rateList = rateList;
	}
	
		} 
	