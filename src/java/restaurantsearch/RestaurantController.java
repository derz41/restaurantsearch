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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Matt
 */
@Named(value = "restaurantController")
@SessionScoped
public class RestaurantController implements Serializable {

    RestaurantHelper helper;

    private String keyword;
    
    DataModel restaurants;
    
    Restaurant restaurant;
    
    private Restaurant selected;

    /**
     * Creates a new instance of RestaurantController
     */
    public RestaurantController() {
        helper = new RestaurantHelper();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public DataModel getRestaurant() {
        if (keyword != null) {
            restaurants = new ListDataModel(helper.selectRestaurant(keyword));
        }
        return restaurants;
    }

    public Restaurant getSelected() {
        if (selected == null) {
            selected = new Restaurant();
        }
        return selected;
    }

    public void setSelected(Restaurant selected) {
        this.selected = selected;
    }

    public String prepareView() {
        selected = (Restaurant) getRestaurant().getRowData();
        return "nameDetails";
    }

}
