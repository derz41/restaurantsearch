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

    private Restaurant selected;

    private String restaurantName;
    private String restaurantHours;
    private String restaurantPhone;
    private String restaurantAddress;
    private int restaurantId;
    
    boolean rendered;
    
    int userId;

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
        this.userId = userId;
        this.restaurantId = restId;
        selected = (Restaurant) getRestaurant().getRowData();
        return "nameDetails";
    }
    
    public boolean isRenderTable(){
        if (keyword == null){
            rendered = false;
        }else{
            rendered = true;
        }
        return rendered;
    }

}
