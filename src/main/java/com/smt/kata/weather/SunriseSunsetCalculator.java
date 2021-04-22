package com.smt.kata.weather;

import java.io.InputStream;
// JDK 11.x
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.siliconmtn.io.http.SMTHttpConnectionManager;
import com.smt.kata.weather.SunriseSunsetVO.Results;

/****************************************************************************
 * <b>Title:</b> SunriseSunsetCalculator.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> In this Kata, you will call out to a json api and format it into 
 * a data structure and return the data structure.  You will use the Gson json classes
 * to deserialize the response from a json object into a SunriseSunsetVO object
 * 
 * You may use the SMTHttpConnectionManager for the API calls
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 20, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class SunriseSunsetCalculator {

    /**
     * Base url for the sunrise sunset calculator
     */
    public static final String SUNRISE_SUNSET_URL = "https://api.sunrise-sunset.org/json?";
    //https://api.sunrise-sunset.org/json?lat=36.7201600&lng=-4.4203400&date=today
    protected String status;
    private SunriseSunsetVO results;
    
    /**
     * 
     */
    public SunriseSunsetCalculator() {
        super();
    }
    
    /**
     * 
     * @param date
     * @param lat
     * @param lng
     * @throws Exception 
     * @throws IOException 
     */
    public SunriseSunsetCalculator(Date date, double lat, double lng) throws Exception {
        super();
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd h:m:s").create();
        StringBuilder path = getBaseURL(date, lat, lng);
        SunriseSunsetVO sun = new SunriseSunsetVO();
        
        try {
            URL url = new URL(path.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream responseStream = connection.getInputStream();
            byte[] res =  responseStream.readAllBytes();
            results = gson.fromJson(new String(res), SunriseSunsetVO.class);
            
        } catch(Exception e) {
            throw new Exception("Unable to retrieve property info", e);
        }    
        
    }
    
    private StringBuilder getBaseURL(Date date, double lat, double lng) {
        
        StringBuilder path = new StringBuilder(128);
        path.append(SUNRISE_SUNSET_URL).append("?");
        path.append("&lat=").append(lat);
        path.append("&lng=").append(lng);
        path.append("&date=").append(date);
        return path;
    }
    
    
    
    public Results getResults() {
        return results.getResults();
    }
    
    public String getStatus() {
        return results.getStatus();
    }
  
     
}


class SunriseSunsetVO implements Serializable {

    private static final long serialVersionUID = -1711126471696728890L;
    
    @SerializedName("results")
    public Results results;
    
    @SerializedName("status")
    public String status;
    

    public Results getResults() {
        return results;
    }



    public void setResults(Results results) {
        this.results = results;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    
    
        public class Results implements Serializable    {
            
            private static final long serialVersionUID = -7285416811705531406L;
    
            @SerializedName("sunrise")
            public String sunrise;
            
            @SerializedName("sunset")
            public String sunset;
            
            @SerializedName("solar_noon")
            public String solarNoon;
            
            @SerializedName("day_length")
            public String dayLength;
            
            @SerializedName("civil_twilight_begin")
            public String civilTwilightBegin;
            
            @SerializedName("civil_twilight_end")
            public String civilTwilightEnd;
            
            @SerializedName("nautical_twilight_begin")
            public String nauticalTwilightBegin;
            
            @SerializedName("nautical_twilight_end")
            public String nauticalTwilightEnd;
            
            @SerializedName("astronomical_twilight_begin")
            public String astronomicalTwilightBegin;
            
            @SerializedName("astronomical_twilight_end")
            public String astronomicalTwilightEnd;
            
            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public String getSolarNoon() {
                return solarNoon;
            }

            public void setSolarNoon(String solarNoon) {
                this.solarNoon = solarNoon;
            }

            public String getDayLength() {
                return dayLength;
            }

            public void setDayLength(String dayLength) {
                this.dayLength = dayLength;
            }

            public String getCivilTwilightBegin() {
                return civilTwilightBegin;
            }

            public void setCivilTwilightBegin(String civilTwilightBegin) {
                this.civilTwilightBegin = civilTwilightBegin;
            }

            public String getCivilTwilightEnd() {
                return civilTwilightEnd;
            }

            public void setCivilTwilightEnd(String civilTwilightEnd) {
                this.civilTwilightEnd = civilTwilightEnd;
            }

            public String getNauticalTwilightBegin() {
                return nauticalTwilightBegin;
            }

            public void setNauticalTwilightBegin(String nauticalTwilightBegin) {
                this.nauticalTwilightBegin = nauticalTwilightBegin;
            }

            public String getNauticalTwilightEnd() {
                return nauticalTwilightEnd;
            }

            public void setNauticalTwilightEnd(String nauticalTwilightEnd) {
                this.nauticalTwilightEnd = nauticalTwilightEnd;
            }

            public String getAstronomicalTwilightBegin() {
                return astronomicalTwilightBegin;
            }

            public void setAstronomicalTwilightBegin(String astronomicalTwilightBegin) {
                this.astronomicalTwilightBegin = astronomicalTwilightBegin;
            }

            public String getAstronomicalTwilightEnd() {
                return astronomicalTwilightEnd;
            }

            public void setAstronomicalTwilightEnd(String astronomicalTwilightEnd) {
                this.astronomicalTwilightEnd = astronomicalTwilightEnd;
            }
            
        
    
    }


}