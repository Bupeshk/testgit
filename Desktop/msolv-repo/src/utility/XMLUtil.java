package utility;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLUtil {

	String inputTEOCCRnum=null;
	String inputPOID=null;
	String responseTEOCCRnum=null;
	String responsePOID=null;
	String responseACKCODE = null;
	String inputBOMALTID;
	String responseBOMALTID;
	String inputSHIPPINGNOTICE;
	String inputPONUMBER;
	String inputLINENUM;
	String Sqtyvalue,Ssign,Suom,Snumofdec,Syear,Smonth,Sday,Shour,Sminute,Ssecond,Soperamtvalue,Spolinenum,Sitemx,Spoorderlindesc,Smatl_type,Sjoblocaddr,Scllicode;
	String Sitem;
	String responseDESCRIPTN = null;
	DatabaseUtil dbUtil= new DatabaseUtil();
	PropertyUtility  putil = new PropertyUtility(XML_Constant.XMLValidation_PropPath);


	
	public void xmlvalid(String xmlstatus,String fileName,String updatedFileName) throws Exception
	{
		DocumentBuilderFactory docBuilderFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder= docBuilderFactory.newDocumentBuilder();
        Document doc = null;
			
        switch(xmlstatus.toLowerCase())
			{
			case "teoinput":
			case "teoresponse":
			case "ccppoinput":
			case "ccpporesponse":
			case "bominput":
			case "bomresponse" :
			case "vsappocreationinput":
			case "vsappocreationresponse":
			case "vsapponewlineresponse":
			case "coeppoinput":
			case "coepporesponse":
			case "vsappoainput":
			case "vsappoaresponse":
			case "vsappoasninput":
			case "vsappoasnresponse":
			case "pkmsinput":
			case "pkmsresponse":
							doc= docBuilder.parse(new File(fileName+".xml"));
		                   	doc.getDocumentElement().normalize();
		                   	findreqTag(doc,xmlstatus,"");
		                   	break;
			case "vsapponewlineinput":
							doc= docBuilder.parse(new File(fileName+".xml"));
							doc.getDocumentElement().normalize();
							findreqTag(doc, xmlstatus,updatedFileName);
							break;
			case "pkms340input":
							doc= docBuilder.parse(new File(fileName+".xml"));
							doc.getDocumentElement().normalize();
							findreqTag(doc, xmlstatus,updatedFileName);
							break;
			}
	}
	
	
	
	public  void findreqTag(Document doc,String xmlstatus,String updatedFileName) throws Exception 
	{
		NodeList reqnodelist;
		NodeList confirmnodelist;
		NodeList primarykeynodelist;
		NodeList dataareanodelist;
		Element confirmelements;
		Element primarykeyelements;
		Element reqele;
		switch(xmlstatus.toLowerCase())
		{
		case "pkmsresponse":
						try
							{
							dataareanodelist=doc.getElementsByTagName("DATAAREA".toLowerCase());
							if(dataareanodelist.getLength()!=0)
							{
								reqele=(Element)dataareanodelist.item(0);
								confirmnodelist=reqele.getElementsByTagName("CONFIRM_BOD".toLowerCase());
								confirmelements= (Element)confirmnodelist.item(0);
								primarykeynodelist = confirmelements.getElementsByTagName("PRIMARY_KEY".toLowerCase());
								primarykeyelements = (Element)primarykeynodelist.item(0);
								if(primarykeyelements.hasChildNodes())
								{
									responseACKCODE=confirmelements.getElementsByTagName("ACKCODE".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseACKCODE);
									Log.info("The ACKCODE in the acknowledge xml of "+xmlstatus+" is found and value is "+responseACKCODE);
									responseDESCRIPTN=confirmelements.getElementsByTagName("DESCRIPTN".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseDESCRIPTN);
									Log.info("The DESCRIPTN in the acknowledge xml of "+xmlstatus+" is found and value is "+responseDESCRIPTN);
									
								}
								else
								{
									responseACKCODE=confirmelements.getElementsByTagName("ACKCODE".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseACKCODE);
									Log.info("The ACKCODE in the acknowledge xml of "+xmlstatus+" is found and value is "+responseACKCODE);
									responseDESCRIPTN=confirmelements.getElementsByTagName("DESCRIPTN".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseDESCRIPTN);
									Log.info("The DESCRIPTN in the acknowledge xml of "+xmlstatus+" is found and value is "+responseDESCRIPTN);
								}
							}
							else
							{
								dataareanodelist=doc.getElementsByTagName("DATAAREA");
								reqele=(Element)dataareanodelist.item(0);
								confirmnodelist=reqele.getElementsByTagName("CONFIRM_BOD");
								confirmelements= (Element)confirmnodelist.item(0);
								primarykeynodelist = confirmelements.getElementsByTagName("PRIMARY_KEY");
								primarykeyelements = (Element)primarykeynodelist.item(0);
								if(primarykeyelements.hasChildNodes())
								{
									responseACKCODE=confirmelements.getElementsByTagName("ACKCODE".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseACKCODE);
									Log.info("The ACKCODE in the acknowledge xml of "+xmlstatus+" is found and value is "+responseACKCODE);
									responseDESCRIPTN=confirmelements.getElementsByTagName("DESCRIPTN".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseDESCRIPTN);
									Log.info("The DESCRIPTN in the acknowledge xml of "+xmlstatus+" is found and value is "+responseDESCRIPTN);
									
								}
								else
								{
									responseACKCODE=confirmelements.getElementsByTagName("ACKCODE".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseACKCODE);
									Log.info("The ACKCODE in the acknowledge xml of "+xmlstatus+" is found and value is "+responseACKCODE);
									responseDESCRIPTN=confirmelements.getElementsByTagName("DESCRIPTN".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseDESCRIPTN);
									Log.info("The DESCRIPTN in the acknowledge xml of "+xmlstatus+" is found and value is "+responseDESCRIPTN);
								}
							}
							}
						catch(Exception e)
							{
							e.getMessage();
							Log.error("Cannot find required tags in acknowledge xml of "+xmlstatus);
							throw e;
							}
						break;
		case "vsappocreationresponse": 
		case "vsapponewlineresponse":
		case "ccpporesponse": 
		case "bomresponse":
		case "teoresponse":
		case "coepporesponse":
		case "vsappoaresponse":
		case "vsappoasnresponse":
		
						try
						{
							dataareanodelist=doc.getElementsByTagName("DATAAREA".toLowerCase());
							if(dataareanodelist.getLength()!=0)
							{
								reqele=(Element)dataareanodelist.item(0);
								confirmnodelist=reqele.getElementsByTagName("CONFIRM_BOD".toLowerCase());
								confirmelements= (Element)confirmnodelist.item(0);
								primarykeynodelist = confirmelements.getElementsByTagName("PRIMARY_KEY".toLowerCase());
								primarykeyelements = (Element)primarykeynodelist.item(0);
								if(primarykeyelements.hasChildNodes())
								{
								responsePOID=primarykeyelements.getElementsByTagName("POID".toLowerCase()).item(0).getFirstChild().getNodeValue();
								System.out.println(responsePOID);
								Log.info("The POID in the acknowledge xml of "+xmlstatus+" is found and value is "+responsePOID);
								}
								if(xmlstatus.equalsIgnoreCase("bomresponse") && primarykeyelements.hasChildNodes())
								{
									/*responsePOID=primarykeyelements.getElementsByTagName("POID".toLowerCase()).item(0).getFirstChild().getNodeValue();
									Log.info("The POID in the acknowledge xml of "+xmlstatus+" is found and value is "+responsePOID);*/
									responseBOMALTID = primarykeyelements.getElementsByTagName("BOMALTID".toLowerCase()).item(0).getFirstChild().getNodeValue();
									Log.info("The BOMALTID in the acknowledge xml of "+xmlstatus+" is found and value is "+responseBOMALTID);
								}
								if(xmlstatus.equalsIgnoreCase("teoresponse") && primarykeyelements.hasChildNodes())
								{
									responseTEOCCRnum=primarykeyelements.getElementsByTagName("CCRN_NUM".toLowerCase()).item(0).getFirstChild().getNodeValue();
									System.out.println(responseTEOCCRnum);
									Log.info("The CCR_NUM in the acknowledge xml of "+xmlstatus+" is found and value is "+ responseTEOCCRnum);
								}
								responseACKCODE=confirmelements.getElementsByTagName("ACKCODE".toLowerCase()).item(0).getFirstChild().getNodeValue();
								System.out.println(responseACKCODE);
								Log.info("The ACKCODE in the acknowledge xml of "+xmlstatus+" is found and value is "+responseACKCODE);
								responseDESCRIPTN=confirmelements.getElementsByTagName("DESCRIPTN".toLowerCase()).item(0).getFirstChild().getNodeValue();
								System.out.println(responseDESCRIPTN);
								Log.info("The DESCRIPTN in the acknowledge xml of "+xmlstatus+" is found and value is "+responseDESCRIPTN);
							
							}
							else
							{
								dataareanodelist=doc.getElementsByTagName("DATAAREA");
								reqele=(Element)dataareanodelist.item(0);
								confirmnodelist=reqele.getElementsByTagName("CONFIRM_BOD");
								confirmelements= (Element)confirmnodelist.item(0);
								primarykeynodelist = confirmelements.getElementsByTagName("PRIMARY_KEY");
								primarykeyelements = (Element)primarykeynodelist.item(0);
								if(primarykeyelements.hasChildNodes())
								{
								responsePOID=primarykeyelements.getElementsByTagName("POID").item(0).getFirstChild().getNodeValue();
								//System.out.println(responsePOID);
								Log.info("The POID in the acknowledge xml of "+xmlstatus+" is found and value is "+responsePOID);
								}
								if(xmlstatus.equalsIgnoreCase("bomresponse") && primarykeyelements.hasChildNodes())
								{
									/*responsePOID=primarykeyelements.getElementsByTagName("POID").item(0).getFirstChild().getNodeValue();
									Log.info("The POID in the acknowledge xml of "+xmlstatus+" is found and value is "+responsePOID);*/
									responseBOMALTID = primarykeyelements.getElementsByTagName("BOMALTID").item(0).getFirstChild().getNodeValue();
									Log.info("The BOMALTID in the acknowledge xml of "+xmlstatus+" is found and value is "+responseBOMALTID);
								}
								if(xmlstatus.equalsIgnoreCase("teoresponse") && primarykeyelements.hasChildNodes())
								{
									responseTEOCCRnum=primarykeyelements.getElementsByTagName("CCRN_NUM").item(0).getFirstChild().getNodeValue();
									//System.out.println(responseTEOCCRnum);
									Log.info("The CCR_NUM in the acknowledge xml of "+xmlstatus+" is found and value is "+ responseTEOCCRnum);
								}
								responseACKCODE=confirmelements.getElementsByTagName("ACKCODE").item(0).getFirstChild().getNodeValue();
								//System.out.println(responseACKCODE);
								Log.info("The ACKCODE in the acknowledge xml of "+xmlstatus+" is found and value is "+responseACKCODE);
								responseDESCRIPTN=confirmelements.getElementsByTagName("DESCRIPTN").item(0).getFirstChild().getNodeValue();
								//System.out.println(responseDESCRIPTN);
								Log.info("The DESCRIPTN in the acknowledge xml of "+xmlstatus+" is found and value is "+responseDESCRIPTN);
			    			}
						}
						catch(Exception e)
						{
							e.getMessage();
							Log.error("Cannot find required tags in acknowledge xml of "+xmlstatus);
							throw e;
						}
			            
			            break;
		case "ccppoinput": 
		case "vsappocreationinput":
		case "teoinput":
						try
						{
							reqnodelist = doc.getElementsByTagName("POID");
							inputPOID= reqnodelist.item(0).getFirstChild().getNodeValue();
							Log.info("The input POID of "+xmlstatus+" is found and value is"+inputPOID);
							if(xmlstatus.equalsIgnoreCase("teoinput"))
							{
								NodeList ccrnumnodelist = doc.getElementsByTagName("CCR_NUM");
								inputTEOCCRnum = ccrnumnodelist.item(0).getFirstChild().getNodeValue();
								Log.info("The input TEO CCR_NUM found and value is"+inputTEOCCRnum);
							}
						}
						catch(NullPointerException e)
						{
							e.getMessage();
							Log.error("Cannot find required Tags in the input file of "+xmlstatus);
							throw e;
						}
						break;
            
		case "bominput":
						try
						{
							reqnodelist= doc.getElementsByTagName("DATAAREA");
							reqele=(Element)reqnodelist.item(0);
							NodeList show_bomnodelist= reqele.getElementsByTagName("SHOW_BOM");
							Element show_bomelements = (Element)show_bomnodelist.item(0);
							NodeList bomheadernodelist= show_bomelements.getElementsByTagName("BOMHEADER");
							Element bomheaderelement = (Element)bomheadernodelist.item(0);
							inputBOMALTID= bomheaderelement.getElementsByTagName("BOMALTID").item(0).getFirstChild().getNodeValue();
							Log.info("The input BOMALTID of "+xmlstatus+" is found and value is "+inputBOMALTID);
						}
						catch(Exception e)
						{
							e.getMessage();
							Log.error("Cannot find required Tags in the input file of "+xmlstatus);
							throw e;
						}
						break;
		case "coeppoinput":
						try
						{
							reqnodelist =doc.getElementsByTagName("RESPONSE_DATA");
							reqele = (Element)reqnodelist.item(0);
							NodeList recordnodelist= reqele.getElementsByTagName("RECORD");
							Element recordelements = (Element)recordnodelist.item(0);
							inputSHIPPINGNOTICE = recordelements.getElementsByTagName("SHIPPING_NOTICE").item(0).getFirstChild().getNodeValue();
							Log.info("The input SHIPPING_NOTICE of "+xmlstatus+" is found and value is "+inputSHIPPINGNOTICE);
						}
						catch(Exception e)
						{
							e.getMessage();
							Log.error("Cannot find shipping notice tag in the input file of "+xmlstatus);
							throw e;
						}
						break;
		case "vsappoainput":
		case "vsappoasninput":
		case "pkmsinput":
						try
						{
							reqnodelist = doc.getElementsByTagName("DATAAREA");
							reqele = (Element)reqnodelist.item(0);
							NodeList processnodelist = reqele.getElementsByTagName("PROCESS_POA_ASN");
							Element processelements = (Element)processnodelist.item(0);
							if(xmlstatus.equalsIgnoreCase("pkmsinput"))
							processelements= (Element) reqele.getElementsByTagName("PROCESS_WMS").item(0);
							NodeList headernodelist = processelements.getElementsByTagName("HEADER");
							Element headerelements = (Element)headernodelist.item(0);
							inputPONUMBER = headerelements.getElementsByTagName("PO_NUMBER").item(0).getFirstChild().getNodeValue();
							Log.info("The input PO_NUMBER of "+xmlstatus+" is found and value is "+inputPONUMBER);
							Element detailelements = (Element)headerelements.getElementsByTagName("DETAIL").item(0);
							inputLINENUM = detailelements.getElementsByTagName("LINENUM").item(0).getFirstChild().getNodeValue();
							Log.info("The input LINENUM of "+xmlstatus+" is found and value is "+inputLINENUM);
						}
						catch(Exception e)
						{
							Log.error(e.getMessage());
							Log.error("Cannot find PO_NUMBER tag in the input file of "+xmlstatus);
							throw e;
						}
						break;
		case "vsapponewlineinput":
						reqnodelist = doc.getElementsByTagName("POID");
						inputPOID= reqnodelist.item(0).getFirstChild().getNodeValue();
						Log.info("The input POID of "+xmlstatus+" is found and value is"+inputPOID);
			
						reqnodelist= doc.getElementsByTagName("POORDERLIN");
						int no= reqnodelist.getLength();
						reqele = (Element)reqnodelist.item(no-1);
						
						Element qtyelements = (Element)reqele.getElementsByTagName("QUANTITY").item(0);
						Sqtyvalue= qtyelements.getElementsByTagName("VALUE").item(0).getFirstChild().getNodeValue();
						Snumofdec= qtyelements.getElementsByTagName("NUMOFDEC").item(0).getFirstChild().getNodeValue();
						Ssign= qtyelements.getElementsByTagName("SIGN").item(0).getFirstChild().getNodeValue();
						Suom= qtyelements.getElementsByTagName("UOM").item(0).getFirstChild().getNodeValue();
						
						Element dtelements = (Element)reqele.getElementsByTagName("DATETIME").item(0);
						Syear= dtelements.getElementsByTagName("YEAR").item(0).getFirstChild().getNodeValue();
						Smonth= dtelements.getElementsByTagName("MONTH").item(0).getFirstChild().getNodeValue();
						Sday= dtelements.getElementsByTagName("DAY").item(0).getFirstChild().getNodeValue();
						Shour= dtelements.getElementsByTagName("HOUR").item(0).getFirstChild().getNodeValue();
						Sminute= dtelements.getElementsByTagName("MINUTE").item(0).getFirstChild().getNodeValue();
						Ssecond= dtelements.getElementsByTagName("SECOND").item(0).getFirstChild().getNodeValue();
						
						Element operamtelements = (Element)reqele.getElementsByTagName("OPERAMT").item(0);
						Soperamtvalue= operamtelements.getElementsByTagName("VALUE").item(0).getFirstChild().getNodeValue();
						
						Spolinenum = reqele.getElementsByTagName("POLINENUM").item(0).getFirstChild().getNodeValue();
						Sitem = reqele.getElementsByTagName("ITEM").item(0).getFirstChild().getNodeValue();
						Sitemx = reqele.getElementsByTagName("ITEMX").item(0).getFirstChild().getNodeValue();
						Spoorderlindesc = reqele.getElementsByTagName("DESCRIPTN").item(0).getFirstChild().getNodeValue();
						Smatl_type = reqele.getElementsByTagName("MATL_TYPE").item(0).getFirstChild().getNodeValue();
						
						Element userareaelements = (Element)reqele.getElementsByTagName("USERAREA").item(0);
						Element bapouserelements = (Element) userareaelements.getElementsByTagName("BA_POORDERLIN_USERAREA").item(0);
						Sjoblocaddr = bapouserelements.getElementsByTagName("JOBLOCADDR").item(0).getFirstChild().getNodeValue();
						Scllicode =  bapouserelements.getElementsByTagName("CLLICODE").item(0).getFirstChild().getNodeValue();
						
						NodeList processnodelist = doc.getElementsByTagName("PROCESS_PO");
						
						Element processelements = (Element)processnodelist.item(0);
						Element poorderlin = doc.createElement("POORDERLIN");
						processelements.appendChild(poorderlin);
						
						Element quantity = doc.createElement("QUANTITY");
						Attr qtyatrribute = doc.createAttribute("qualifier");
						qtyatrribute.setValue("REQUIRED");
						quantity.setAttributeNode(qtyatrribute);
						
						Element datetime = doc.createElement("DATETIME");
						Attr dtatrribute = doc.createAttribute("qualifier");
						dtatrribute.setValue("SHIPDATE");
						datetime.setAttributeNode(dtatrribute);
						
						Element operamt = doc.createElement("OPERAMT");
						Attr opermatrribute = doc.createAttribute("qualifier");
						opermatrribute.setValue("COST");
						operamt.setAttributeNode(opermatrribute);
						
						Element polinenum = doc.createElement("POLINENUM");
						polinenum.appendChild(doc.createTextNode("000"+(no+1)+"0"));
						
						Element item = doc.createElement("ITEM");
						item.appendChild(doc.createTextNode(Sitem));
						
						Element itemx = doc.createElement("ITEMX");
						itemx.appendChild(doc.createTextNode(Sitemx));
						
						Element descriptn = doc.createElement("DESCRIPTN");
						descriptn.appendChild(doc.createTextNode(Spoorderlindesc));
						
						Element matl_type = doc.createElement("MATL_TYPE");
						matl_type.appendChild(doc.createTextNode(Smatl_type));
						
						Element userarea = doc.createElement("USERAREA");
						
						Element value = doc.createElement("VALUE");
						value.appendChild(doc.createTextNode(Sqtyvalue));
						
						Element numofdec = doc.createElement("NUMOFDEC");
						numofdec.appendChild(doc.createTextNode(Snumofdec));
						
						Element sign = doc.createElement("SIGN");
						sign.appendChild(doc.createTextNode(Ssign));
						
						Element uom = doc.createElement("UOM");
						uom.appendChild(doc.createTextNode(Suom));
						
						Element year = doc.createElement("YEAR");
						year.appendChild(doc.createTextNode(Syear));
						
						Element month = doc.createElement("MONTH");
						month.appendChild(doc.createTextNode(Smonth));
						
						Element day = doc.createElement("DAY");
						day.appendChild(doc.createTextNode(Sday));
						
						Element hour = doc.createElement("HOUR");
						hour.appendChild(doc.createTextNode(Shour));
						
						Element minute = doc.createElement("MINUTE");
						minute.appendChild(doc.createTextNode(Sminute));
						
						Element second = doc.createElement("SECOND");
						second.appendChild(doc.createTextNode(Ssecond));
						
						Element baorderuser = doc.createElement("BA_POORDERLIN_USERAREA");
						Element joblocaddr = doc.createElement("JOBLOCADDR");
						joblocaddr.appendChild(doc.createTextNode(Sjoblocaddr));
						
						Element cllicode = doc.createElement("CLLICODE");
						cllicode.appendChild(doc.createTextNode(Scllicode));
						
						Element operamtvalue = doc.createElement("VALUE");
						operamtvalue.appendChild(doc.createTextNode(Soperamtvalue));
						
						poorderlin.appendChild(quantity);
						poorderlin.appendChild(datetime);
						poorderlin.appendChild(operamt);
						poorderlin.appendChild(polinenum);
						poorderlin.appendChild(item);
						poorderlin.appendChild(itemx);
						poorderlin.appendChild(descriptn);
						poorderlin.appendChild(matl_type);
						poorderlin.appendChild(userarea);
						
						quantity.appendChild(value);
						quantity.appendChild(numofdec);
						quantity.appendChild(sign);
						quantity.appendChild(uom);
						
						datetime.appendChild(year);
						datetime.appendChild(month);
						datetime.appendChild(day);
						datetime.appendChild(hour);
						datetime.appendChild(minute);
						datetime.appendChild(second);
						
						operamt.appendChild(operamtvalue);
						userarea.appendChild(baorderuser);
						baorderuser.appendChild(joblocaddr);
						baorderuser.appendChild(cllicode);
						
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer;
						try {
							transformer = transformerFactory.newTransformer();
						} catch (TransformerConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw e;
						}
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(updatedFileName+".xml"));
						try {
							transformer.transform(source, result);
						} catch (TransformerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
		case "pkms340input":
						ExcelUtils.setExcelFile(GUI_Constant.Path_TestData+GUI_Constant.File1_TestData, "Callout_Functionality");
						String tracknum = ExcelUtils.getExcelData("Tracking_Number", "Iteration1");
						System.out.println(tracknum);
						inputPONUMBER= doc.getElementsByTagName("PO_NUMBER").item(0).getFirstChild().getNodeValue();
						doc.getElementsByTagName("TRACKING_NUMBER").item(0).getFirstChild().setNodeValue(tracknum);
						TransformerFactory transformerFac = TransformerFactory.newInstance();
						Transformer transform;
						try {
							transform = transformerFac.newTransformer();
						} catch (TransformerConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw e;
						}
						DOMSource source1 = new DOMSource(doc);
						StreamResult result1 = new StreamResult(new File(updatedFileName+".xml"));
						try {
							transform.transform(source1, result1);
						} catch (TransformerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
		}
	}
	
	public  StringBuilder xmlRead(String fileName) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		String xmlText= null;
		FileInputStream fis=null;
		InputStreamReader isr = null;
		Scanner sc;
		fis = new FileInputStream(fileName+".xml");
		isr = new InputStreamReader(fis);
		sc= new Scanner(isr);
		while(sc.hasNextLine())
		{
			xmlText= sc.nextLine();
			sb.append(xmlText);
		}
		if(sc.hasNextLine())
		{
			System.out.println("true there is a line");
		}
		Log.info(fileName+" input file is found and copied the input file");
		sc.close();

		for(int i=0;i<sb.length();++i)
		{
			if(Character.isWhitespace(sb.charAt(i)) && sb.charAt(i-1)=='>')
			{
	            sb.deleteCharAt(i);
	            i--;
	        }
	    }
	
		System.out.println(sb);
		return sb;
	}
	
	public void createAcknowledgeXML(String resultxml,String fileName ) throws IOException
	{
		
		File acknowledgexml;
		FileWriter fw;
		BufferedWriter bw;
		acknowledgexml= new File(fileName+".xml");
		fw= new FileWriter(acknowledgexml.getAbsolutePath());
		bw= new BufferedWriter(fw);
		bw.write(resultxml);
		bw.close();

	}
	
	
	public String checkDBrow(String validationType) throws Exception
	{
		String sleeptime =putil.getEnvironmentProperty("sleeptime");
		long i = StringToLong(sleeptime);
		String status = null;
		String query;
		switch(validationType.toLowerCase())
		{
		case "teo":
					
					
					if(responseACKCODE.equals("0"))
						{
							if(inputTEOCCRnum.equals(responseTEOCCRnum))
							{
							System.out.println("The CCR_NUM in the input xml and acknowkedge xml are same. The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
							query = "Select * from TEO where TEO_Number ='"+inputPOID+"'";
							try {
								Thread.sleep(i);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								status= dbUtil.DBread(query);
							} catch (  ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								throw e;
							}
							
						}
							
					}
					if(!responseACKCODE.equals("0"))
					{
						
						status="updated XML submission failed because of Duplicate PO";
				
						System.out.println("The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
						Log.error("The xml updation of "+validationType+ " is failed");
					
					}
					
					break;
		case "vsappocreation":
		case "vsapponewline":
		case "ccppo":
					if(responseACKCODE.equals("0"))
						{
						
							
							query ="select * from purchase_order where po_Number='"+responsePOID+"'";
							try {
								Thread.sleep(i);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								
								}
							try {
								status=dbUtil.DBread(query);
								query = "select * from line_items where po_Number='"+responsePOID+"'";
								status=dbUtil.DBread(query);
								query= "select * from MATERIAL_DETAILS where po_Number='"+responsePOID+"'";
								status=dbUtil.DBread(query);
								if(validationType.equalsIgnoreCase("ccppo"))
									{
									query= "select * from  po_flags where po_Number='"+responsePOID+"'";
									status=dbUtil.DBread(query);
									query= "select * from  tr_purchase_order where po_Number='"+responsePOID+"'";
									status=dbUtil.DBread(query);
									}
								}
							catch(Exception e)
								{
									e.getMessage();
									Log.error("Failed to fetch required records of "+validationType);
								}
								if(inputPOID.equals(responsePOID))
								{
								System.out.println("The POID in the input xml and acknowkedge xml are same. The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
								}
							
						}	
					if(!responseACKCODE.equals("0"))
						{
							status="updated XML submission failed because of Duplicate PO";
							System.out.println("The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
							Log.error("The xml updation of "+validationType+ " is failed");
							
						}
					break;
		case "pkms":
			if(responseACKCODE.equals("0"))
			{
			
				
				query ="select * from purchase_order where po_Number='"+inputPONUMBER+"'";
				try {
					Thread.sleep(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
				try {
					status=dbUtil.DBread(query);
					query = "select * from line_items where po_Number='"+inputPONUMBER+"'";
					status=dbUtil.DBread(query);
					query= "select * from MATERIAL_DETAILS where po_Number='"+inputPONUMBER+"'";
					status=dbUtil.DBread(query);
					if(validationType.equalsIgnoreCase("ccppo"))
						{
						query= "select * from  po_flags where po_Number='"+inputPONUMBER+"'";
						status=dbUtil.DBread(query);
						query= "select * from  tr_purchase_order where po_Number='"+inputPONUMBER+"'";
						status=dbUtil.DBread(query);
						}
					}
				catch(Exception e)
					{
						e.getMessage();
						Log.error("Failed to fetch required records of "+validationType);
					}
			}	
		if(!responseACKCODE.equals("0"))
			{
				status="updated XML submission failed because of Duplicate PO";
				System.out.println("The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
				Log.error("The xml updation of "+validationType+ " is failed");
				
			}
		break;
					
					
		case "bom":
					if(responseACKCODE.equals("0"))
						{
						if(inputBOMALTID.equals(responseBOMALTID))
							{
							System.out.println("The POID in the input xml and acknowkedge xml are same. The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
							query =" select * from MATERIAL_DETAILS where BOM_LINE_NUMBER=49 and PO_NUMBER='"+responsePOID+"'";
							try {
									Thread.sleep(i);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							try 
								{
									status=dbUtil.DBread(query);
									query = "select * from bom_items where PO_NUMBER='"+responsePOID+"'and BOM_item_NUMBER=49";
									status=dbUtil.DBread(query);
									query="select * from PURCHASE_ORDER where  PO_NUMBER='"+responsePOID+"'";
									status=dbUtil.DBread(query);
								}
							catch(Exception e)
								{
									e.getMessage();
									Log.error("Failed to fetch required records of "+validationType);
								
								}
							}
						}	
					if(!responseACKCODE.equals("0"))
					{
						status="updated XML submission failed because of Duplicate PO";
						System.out.println("The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
						Log.error("The xml updation of "+validationType+ " is failed");
						
					}
					break;
		case "coeppo":
				if(responseACKCODE.equals("0"))
				{
					if(inputSHIPPINGNOTICE.equals(responsePOID))
					{
						try{
						System.out.println("The SHIPPING_NOTICE in the input xml and  POID in acknowkedge xml are same. The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
						Thread.sleep(i);
						query= "select * from purchase_order where po_Number='"+responsePOID+"'";
						status=dbUtil.DBread(query);
						query="select * from line_items where po_Number='"+responsePOID+"'";
						status=dbUtil.DBread(query);
						query="select * from MATERIAL_DETAILS where po_Number='"+responsePOID+"'";
						status=dbUtil.DBread(query);
						query= "SELECT WEST_PICS,ORIGIN FROM PURCHASE_ORDER WHERE WEST_PICS='Y'";
						status=dbUtil.DBread(query);
						}
						catch(Exception e)
						{
							e.getMessage();
							Log.error("Failed to fetch required records of "+validationType);
							
						}
					}
				}
				if(!responseACKCODE.equals("0"))
				{
					status="updated XML submission failed because of Duplicate PO";
					System.out.println("The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
					Log.error("The xml updation of "+validationType+ " is failed");
					
				}
				break;	
		
		case "vsappoa":
		case "vsappoasn":
				if(responseACKCODE.equals("0"))
				{
					try
					{
					if(inputPONUMBER.equals(responsePOID))
						{
						System.out.println("The PO_NUMBER in the input xml and  POID in acknowkedge xml are same. The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
						Thread.sleep(i);
						query= "select * from line_comments where po_number='"+responsePOID+"' and line_number='"+inputLINENUM+"'";
						status=dbUtil.DBread(query);
						}
					}
					catch(Exception e)
					{
					Log.error("Failed to fetch required records of "+validationType);
			
					}
				}
				if(!responseACKCODE.equals("0"))
				{
					status="updated XML submission failed because of Duplicate PO";
					System.out.println("The ACKCODE is "+ responseACKCODE+" and description is "+responseDESCRIPTN);
					Log.error("The xml updation of "+validationType+ " is failed");
					
				}
				break;

			}
		return status;
	}
	
    
public long StringToLong(String inputstring)
	{
		Long lObj = Long.valueOf(inputstring);
		Long i = lObj.longValue();
		System.out.println(i);
		return i;

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


