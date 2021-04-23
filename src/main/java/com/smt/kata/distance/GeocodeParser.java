package com.smt.kata.distance;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Kata imports
import com.smt.kata.distance.bean.Location;

/****************************************************************************
 * <b>Title:</b> GeocodeParser.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Geocode Parser
 * 
 * In this kata, you must connect to an SMT geocoder and parse the response into 
 * the provided location object (com.smt.kata.distance.bean.Location)
 * 
 * The response from the geocoder is in XML format.  You may use any libraries
 * that are included in the JDK.  The javax.xml, javax.xml.parsers and org.w3c.dom
 * are great places to start.  You may use Xpath or DocumentBuilders to solve
 * this kata.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 21, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class GeocodeParser {
    
    /**
     * Base URL
     * Example: http://smtproxy-dev.aws.siliconmtn.com/websvc/geocoder?addr=&city=&state=&zip=80211&country=US
     */
    public static final String SMT_GEO_URL = "http://smtproxy-dev.aws.siliconmtn.com/websvc/geocoder?";
    
    /**
     * 
     */
    private String addr,city,state,zip,country;
    public GeocodeParser() {
        super();
    }
    

    /**
     * Makes a geocode request and parses the results into a location object
     * @param addr Address to geocode
     * @param city city name
     * @param state state 2 letter code
     * @param zip zip code to geocode
     * @param country 2 letter iso country code
     * @return Geocoded location
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public Location getGeocode(String addr, String city, String state, String zip, String country) throws ParserConfigurationException, SAXException, IOException {
        this.addr=addr;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.country=country;
        Location loc = new Location();
        
         String url = SMT_GEO_URL+"addr="+this.addr+"&city="+this.city+"&state="+this.state+"&zip="+this.zip+"&country="+this.country;
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setNamespaceAware(false);
            f.setValidating(false);
            DocumentBuilder b = f.newDocumentBuilder();
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.addRequestProperty("Accept", "application/xml");
            Document doc = b.parse(urlConnection.getInputStream());
            Node list = doc.getDocumentElement().getElementsByTagName("GeocodeLocation").item(0);
            Element ele = (Element) list;
            loc.setAddress(ele.getElementsByTagName("Address").item(0).getTextContent());
            loc.setAddress2(address2);
            loc.setCity(city);
            loc.setCountry(country);
            loc.setCountryName(countryName);
            loc.setLatitude(latitude);
            loc.
            
            

        
        return loc;
    }
//    protected String address;
//    protected String address2;
//    protected String city;
//    protected String county;
//    protected String zipCode;
//    protected String zipSuffixCode;
//    protected String state;
//    protected String country;
//    protected String countryName;
//    protected double latitude = 0.0;
//    protected double longitude = 0.0;
}