package com.verizon.cao.selenium.common;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParserUtil {
	
	public boolean isExtranetTC(String xmlFilePath){
		boolean result = false;
		try{
			File xmlFile = new File(xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();	
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("class");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementParam = (Element) nNode;
					if (eElementParam.getAttribute("name").toLowerCase().contains("Extranet_User_Test"))
						result = true;
				}
			}
			return result;
		}
		catch (Exception e) {
	         return false; 
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

