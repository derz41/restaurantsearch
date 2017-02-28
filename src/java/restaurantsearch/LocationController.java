/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gabor_000
 */
@Named(value = "locationController")
@SessionScoped
public class LocationController implements Serializable{
    
    // these fields map directly to components in the location.xhtml
    String keyWord;
    String response;
    // this is our class that uses Hibernate to query the location table
    LocationHelper helper;

    // this is our Actor POJO
    Location location;
    

    /**
     * Creates a new instance of locationController
     */
    public LocationController() {
        helper = new LocationHelper();
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}
