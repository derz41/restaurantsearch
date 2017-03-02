/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import java.io.Serializable;
import java.util.List;
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
    //Hi
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
        
        List<Location> rest = null;
        
        if (keyWord != null){
            
        
        rest = helper.selectRestaurantByLocation(this.keyWord);
        StringBuilder cast = new StringBuilder();
        for(int i = 0; i < rest.size(); i++){
            Restaurant print = (Restaurant) print.get(i);
            cast.append(print.getRestaurantName());
            cast.append(" ");
        }
        return cast.toString();
        
        } else {
            response = " ";
            return response;
        }
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
