/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author gabor_000
 */
@Named(value = "locationController")
@SessionScoped
public class LocationController implements Serializable {

    DataModel restaurants;

    LocationHelper helper;

    Location location;

    private Restaurant selected;

    String keyword;

    boolean rendered;

    private int restaurantId;
    
    int userId;

    public LocationController() {

        helper = new LocationHelper();

    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public DataModel getRestaurant() {
        if (keyword != null) {
            restaurants = new ListDataModel(helper.selectRestaurantByLocation(keyword));
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

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restId) {
        this.restaurantId = restId;
    }

    public Restaurant getDetails() {
        Restaurant details = helper.getRestaurantDetails(this.restaurantId);
        return details;
    }

    public String prepareView(int restId, int userId) {
        this.restaurantId = restId;
        this.userId = userId;
        selected = (Restaurant) getRestaurant().getRowData();
        return "locationDetails";
    }

    public boolean isRenderTable() {
        if (keyword == null) {
            rendered = false;
        } else {
            rendered = true;
        }
        return rendered;
    }
}
