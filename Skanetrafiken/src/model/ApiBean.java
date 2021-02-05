package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ApiBean {

	private ArrayList<String> lineType = new ArrayList<String>();

	public ArrayList<String> getLineType() {
		return lineType;
	}

	public void setLineType() {
		try {
			apiGet();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	private ArrayList<String> journeyTime = new ArrayList<String>();

	public ArrayList<String> getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime() {

		try {
			apiGet();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private ArrayList<String> journeyTowards = new ArrayList<String>();

	public ArrayList<String> getJourneyTowards() {
		return journeyTowards;
	}

	public void setJourneyTowards() {

		try {
			apiGet();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void apiGet() throws IOException {

		String line;

		String responseContent = new String();

		URL url = new URL("http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=80000");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		while ((line = in.readLine()) != null) {

			responseContent += line;
		}
		in.close();
		System.out.println(responseContent);

		Document doc = convertStringToXMLDocument(responseContent);
		doc.getDocumentElement().normalize();
		System.out.println("Root ele:" + doc.getDocumentElement().getNodeName());

		NodeList lineTypeNameTag = doc.getElementsByTagName("LineTypeName");
		for (int i = 0; i < 10; i++) {
			Node node = lineTypeNameTag.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) node;
				System.out.println(ele.getTextContent());
				lineType.add(lineTypeNameTag.item(i).getTextContent());

			}
		}

		NodeList journeyDateTimeTag = doc.getElementsByTagName("JourneyDateTime");
		for (int i = 0; i < 10; i++) {
			Node node2 = journeyDateTimeTag.item(i);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				//System.out.println(ele2.getTextContent());
				journeyTime.add(journeyDateTimeTag.item(i).getTextContent());

			}
		}

		NodeList journeyTowardsTag = doc.getElementsByTagName("Towards");
		for (int i = 0; i < 10; i++) {
			Node node3 = journeyTowardsTag.item(i);
			if (node3.getNodeType() == Node.ELEMENT_NODE) {
				Element ele3 = (Element) node3;
				//System.out.println(ele3.getTextContent());
				journeyTowards.add(journeyTowardsTag.item(i).getTextContent());

			}
		}

	}

	private static Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {

			builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
