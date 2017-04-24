package com.highradius;

/*Normalize() method usage:::
 * Consider xml 
 * <foo>hello 
	wor
	ld</foo>
 * Without Normalize() method
 * Element foo
	Text node: ""
	Text node: "Hello "
	Text node: "wor"
	Text node: "ld"
 *
 *After Normalize() method
 *Element foo
	Text node: "Hello world"
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.Attributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DeloitteInterviewQuestions {

	public static void main(String... args){
		//tryCatchMethodExample(); //This method is to check whether JVM exits if called in catch block without executing finally block
		try {
			File file = new File("C:\\Users\\bsrinadh\\workspace\\Learnings\\src\\BooksData.xml");
			//XmlParserUsingDOM(file); //XML Parsing using Document Object Model(DOM), will store complete XML in Memory and create a Tree Structure - not efficient with huge XML Data 
			//XmlParserUsingSAX(file); //XML Parsing using Simple API for XML(SAX) a.k.a, PUSH Parser(means application thread needs to read if found XML), makes use of less memory compared with DOM - can only read XML not Write 
			XmlParserUsingSTAX(file); //XML Parsing using Streaming API for XML(STAX) a.k.a, PULL Parser(means application thread reads XML only when called explicitly), same functionality as SAX - but better efficient than SAX
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void XmlParserUsingSTAX(File file) throws FileNotFoundException, XMLStreamException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(file));
		while(eventReader.hasNext()){
			XMLEvent event = eventReader.nextEvent();
			if(event.isStartElement()){
				StartElement startElement = event.asStartElement();
				if(startElement.getName().getLocalPart().equals("book")){
					System.out.println("Book ID: "+startElement.getAttributeByName(new QName("id")).getValue());
				}else if(startElement.getName().getLocalPart().equals("author")){
					event = eventReader.nextEvent();
					System.out.println("Author: "+event.asCharacters().getData());
				}else if(startElement.getName().getLocalPart().equals("title")){
					event = eventReader.nextEvent();
					System.out.println("Title: "+event.asCharacters().getData());
				}else if(startElement.getName().getLocalPart().equals("genre")){
					event = eventReader.nextEvent();
					System.out.println("Genre: "+event.asCharacters().getData());
				}else if(startElement.getName().getLocalPart().equals("price")){
					event = eventReader.nextEvent();
					System.out.println("Price: "+event.asCharacters().getData());
				}else if(startElement.getName().getLocalPart().equals("publish_date")){
					event = eventReader.nextEvent();
					System.out.println("Publish Date: "+event.asCharacters().getData());
				}else if(startElement.getName().getLocalPart().equals("description")){
					event = eventReader.nextEvent();
					System.out.println("Description: "+event.asCharacters().getData());
					System.out.println();
				}				
			}
		}
		
	}


	public static void XmlParserUsingSAX(File file) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxFactory.newSAXParser();
		DefaultHandler defaultHandler = new DefaultHandler(){
		boolean author = false, title = false, genre = false, price = false, publish_date = false, description = false;
		public void startElement(String uri, String localName, String qName,Attributes attributes){
			System.out.println("Start Element: "+qName);
			if(qName.equalsIgnoreCase("author")){
				author = true;
			}else if(qName.equalsIgnoreCase("title")){
				title = true;
			}else if(qName.equalsIgnoreCase("genre")){
				genre = true;
			}else if(qName.equalsIgnoreCase("price")){
				price = true;
			}else if(qName.equalsIgnoreCase("publish_date")){
				publish_date = true;
			}else if(qName.equalsIgnoreCase("description")){
				description = true;
			}
		}
		public void endElement(String uri, String localName,String qName){
				System.out.println("End Element :" + qName);
			}
			public void characters(char ch[], int start, int length){

				if (author) {
					System.out.println("Author: " + new String(ch, start, length));
					author = false;
				}else if (title) {
					System.out.println("Title: " + new String(ch, start, length));
					title = false;
				}else if (genre) {
					System.out.println("Genre : " + new String(ch, start, length));
					genre = false;
				}else if (price) {
					System.out.println("Price : " + new String(ch, start, length));
					price = false;
				}else if (publish_date) {
					System.out.println("Publish Date : " + new String(ch, start, length));
					publish_date = false;
				}else if (description) {
					System.out.println("Description : " + new String(ch, start, length));
					description = false;
				}
			}

		};
		saxParser.parse(file, defaultHandler);
	}


	public static void XmlParserUsingDOM(File file) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(file);
		// below normalize() is for normalizing the Text node's in single sentence. Provided Explanation in comments above.
		doc.getDocumentElement().normalize();
		System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("book");
		System.out.println("----------------------------");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Book id : " + eElement.getAttribute("id"));
				System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
				System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
				System.out.println("Publish_Date : " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
				System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
			}
		}
	}


	public static void tryCatchMethodExample(){
		try{
			throw new Exception();
		}catch(Exception e){
			System.out.println("Exception Caught in Catch");
			System.exit(0);
		}finally{
			System.out.println("In finally Block");
		}
	}
}
