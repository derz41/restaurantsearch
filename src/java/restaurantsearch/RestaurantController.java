/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Matt
 */
@Named(value = "restaurantController")
@Dependent
public class RestaurantController {

    String restaurant;
    String response;
    
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

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
