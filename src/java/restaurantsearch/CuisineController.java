/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author gabor_000
 */
@Named(value = "cuisineController")
@SessionScoped
public class CuisineController implements Serializable {

    DataModel restaurants;
    DataModel login;

    CuisineHelper helper;

    Cuisine cuisine;

    private Restaurant selected;

    String keyword;

    boolean rendered;
    boolean render;

    private int restaurantId;
    int userId;

    public CuisineController() {
        helper = new CuisineHelper();

    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public DataModel getRestaurant() {
            if (keyword != null) {
                restaurants = new ListDataModel(helper.selectRestaurantByCuisine(keyword));
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
        return "cuisineDetails";
    }

    public boolean isRenderTable() {
        if (keyword == null) {
            rendered = false;
        } else {
            rendered = true;
        }
        return rendered;
    }

    public boolean isRenderLogin() {
        if (this.userId == 0) {
            render = true;
        } else {
            render = false;
        }
        return render;
    }
    
    public boolean isRenderLoggedIn() {
        if (this.userId == 0) {
            render = false;
        } else {
            render = true;
        }
        return render;
    }

}
