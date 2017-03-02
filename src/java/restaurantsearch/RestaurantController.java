/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Matt
 */
@Named(value = "restaurantController")
@SessionScoped
public class RestaurantController implements Serializable {

    String restaurant;
    String response;
    String restName;
    
    RestaurantHelper helper;
    
    Restaurant restaurants;
    
    

    /**
     * Creates a new instance of RestaurantController
     */
    public RestaurantController() {
        helper = new RestaurantHelper();
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public List<Restaurant> getResponse() {
        List<Restaurant> rest = helper.selectRestaurant(this.restaurants, this.restName);
        return rest;
        
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
}
