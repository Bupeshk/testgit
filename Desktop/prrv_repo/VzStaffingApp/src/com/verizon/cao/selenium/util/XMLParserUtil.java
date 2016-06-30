package com.verizon.cao.selenium.util;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParserUtil {
	
	public ArrayList <String> getAllTestCases(String xmlFilePath){
		ArrayList <String> testCases = new ArrayList<String>() ;
		try{
			File xmlFile = new File(xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();	
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("test");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String testCase = eElement.getAttribute("name");
					testCases.add(testCase);
				}
			}
			return testCases;
		}
		catch (Exception e) {
			System.out.println("Error while reading the testng.xml "+ e);
	         return testCases; 
		}
	}
		
	public String getAttributeValue(String xmlFilePath, String attributeName){
		String paramValue = "";
		if(attributeName.equalsIgnoreCase("env"))
			paramValue = "Devops";
		else
			paramValue = "Firefox";
		try{
			File xmlFile = new File(xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();	
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("parameter");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementParam = (Element) nNode;
					if (eElementParam.getAttribute("name").equalsIgnoreCase(attributeName))
						paramValue = eElementParam.getAttribute("value");
				}
			}
			return paramValue;
		}
		catch (Exception e) {
			System.out.println("Error while reading the testng.xml in getEnviorenment "+ e);
	         return paramValue; 
		}
	}	
}
