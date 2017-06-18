package org.geonames.feed;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {
		//link1- http://api.geonames.org/findNearbyPostalCodes?postalcode=8775&country=CH&radius=10&username=demo
		List<PostalCode> postalCodes = getPostalCodes("http://api.geonames.org/postalCodeSearch?postalcode=9011&maxRows=10&username=demo");
		
		System.out.println("POSTAL CODE REGIONS");
		System.out.printf("%s\t%s\t%s\t%s\t%s\t","PostalCode","Name","CountryCode","Latitude","Longitude");
		for(PostalCode code: postalCodes){
			System.out.printf("%s\t%s\t%s\t%s\t%s\t",code.getPostalCode(),code.getName(),code.getCountryCode(),code.getLatitude(),code.getLongitude());
		}

	}

	public static List<PostalCode> getPostalCodes(String url) {
		List<PostalCode> list = new ArrayList<>();

		try{
			URL geoUrl = new URL(url);
			URLConnection urlConnection = geoUrl.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
			int responseCode = httpConnection.getResponseCode();

			if(responseCode == HttpURLConnection.HTTP_OK){
				InputStream in = httpConnection.getInputStream();

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document dom = db.parse(in);

				Element docElement = dom.getDocumentElement();
				NodeList nl = docElement.getElementsByTagName("code");
				if(nl != null & nl.getLength() > 0){
					for(int i = 0; i< nl.getLength(); i++){
						Element code = (Element) nl.item(i);
						Element elePostalCode = (Element) code.getElementsByTagName("postalcode").item(0);
						Element eleName = (Element) code.getElementsByTagName("name").item(0);
						Element eleCountryCode = (Element) code.getElementsByTagName("countryCode").item(0);
						Element eleLatitude = (Element) code.getElementsByTagName("lat").item(0);
						Element eleLongitude = (Element) code.getElementsByTagName("lng").item(0);

						String strPostalCode = elePostalCode.getFirstChild().getNodeValue();
						int postalCode = Integer.parseInt(strPostalCode);

						String name = eleName.getFirstChild().getNodeValue();
						String countryCode = eleCountryCode.getFirstChild().getNodeValue();
						String strLatitude = eleLatitude.getFirstChild().getNodeValue();
						Double latitude = Double.parseDouble(strLatitude);
						String strLongitude = eleLongitude.getFirstChild().getNodeValue();
						long longitude = Long.parseLong(strLongitude);

						//PostalCode postalCodeObj = new PostalCode(postalCode,name,countryCode,latitude,longitude);
						//list.add(postalCodeObj);
					}
				}	
			}
		}catch(Exception ex){
			System.out.printf("Error: %s", ex);
		}

		return list;
	}

}
