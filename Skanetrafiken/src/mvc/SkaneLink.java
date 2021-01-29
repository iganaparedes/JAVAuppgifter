package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SkaneLink {

	public static void main(String[] args) {
		
		BufferedReader reader;
		String line;
		String responseContent = new String();
		try {
			URL url = new URL("http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=80000");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent += line;
				}
				reader.close();
			}
			else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent += line;
				}
			
			reader.close();
		}
			System.out.println(responseContent.toString());
			
			Document doc = convertStringtoXMLDocument(responseContent);
			doc.getDocumentElement().normalize();
			System.out.println("Root ele:" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("Line");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element ele = (Element) node;
					System.out.println(ele.getTextContent());
				}
			}
			
			NodeList nList2 = doc.getElementsByTagName("JourneyDateTime");
			for (int i = 0; i < nList2.getLength(); i++) {
				Node node2 = nList2.item(i);
			if(node2.getNodeType() == Node.ELEMENT_NODE) {
					Element ele2 = (Element) node2;
					System.out.println(ele2.getTextContent());
				}
			}
			
			NodeList nList3 = doc.getElementsByTagName("Towards");
			for (int i = 0; i < nList3.getLength(); i++) {
				Node node3 = nList3.item(i);
			if(node3.getNodeType() == Node.ELEMENT_NODE) {
					Element ele3 = (Element) node3;
					System.out.println(ele3.getTextContent());
				}
			}
			
			
			
	}catch (MalformedURLException e)
	{
		e.printStackTrace();
	}catch (IOException e)
	{
		e.printStackTrace();
	}
	}

	private static Document convertStringtoXMLDocument(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
