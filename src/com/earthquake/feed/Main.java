package com.earthquake.feed;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Main {

	public static void main(String[] args) {
		List<Quake> earthquakes = getQuakes("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.atom");
		
		System.out.println("TODAY'S EARTHQUAKES 2.5 AND HIGHER");
		SimpleDateFormat df = new SimpleDateFormat("HH:MM");
		System.out.printf("%s\t%-25s\t\t%s\t%s\n","WHEN","LAT / LONG", "MAGNITUDE","DETAILS");
		Collections.sort(earthquakes,(q1,q2) -> {return q1.getMagnitude() == q2.getMagnitude() ? 0 : q1.getMagnitude() < q2.getMagnitude() ? 1 : -1;});
		for(Quake q : earthquakes){
			System.out.printf("%s\t%-25s\t\t%s\t\t%s\n",df.format(q.getDate()),q.getLocation(),q.getMagnitude(),q.getDetails());
		}
	}

	public static List<Quake> getQuakes(String url) {
		List<Quake> quakes = new ArrayList<>();
		
		try {
			URL eqCentreUrl = new URL(url);
			URLConnection connection = eqCentreUrl.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) connection;
			int responseCode = httpConnection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK){
				InputStream in = httpConnection.getInputStream();
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				
				Document dom = db.parse(in);
				Element docElement = dom.getDocumentElement();
				NodeList nl = docElement.getElementsByTagName("entry");
				if(nl != null && nl.getLength() > 0){
					for(int i =0; i < nl.getLength(); i++){
						Element entry = (Element) nl.item(i);
						Element title = (Element) entry.getElementsByTagName("title").item(0);
						Element g = (Element) entry.getElementsByTagName("georss:point").item(0);
						Element when = (Element) entry.getElementsByTagName("updated").item(0);
						Element link = (Element) entry.getElementsByTagName("link").item(0);
						String details = title.getFirstChild().getNodeValue();
						String hostname = "http://earthquake.usgs.gov";
						String linkString = hostname + link.getAttribute("href");
						
						String point = g.getFirstChild().getNodeValue();
						String dt = when.getFirstChild().getNodeValue();
						SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
						Date qdate = new GregorianCalendar(0, 0, 0).getTime();
						qdate = sdformat.parse(dt);
						
						String[] locationPair = point.split(" ");
						String location = "Lat: " + locationPair[0] +" Lng: "+locationPair[1];
						
						String magnitudeString = details.split(" ")[1];
						double magnitude = Double.parseDouble(magnitudeString);
						
						details = details.split("-")[1].trim();
						
						Quake q = new Quake(qdate,details,location,magnitude,linkString);
						
						quakes.add(q);
					}
				}
			}
		} catch (Exception ex) {
			System.out.printf("Error: %s", ex);
		}
		return quakes;
	}

}
