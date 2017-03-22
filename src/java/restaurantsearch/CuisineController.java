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
@Named(value = "cuisineController")
@SessionScoped
public class CuisineController implements Serializable {

        DataModel restaurants;

        CuisineHelper helper;
        
        Cuisine cuisine;
        
        private Restaurant selected;
        
        String keyword;
        
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
        if (selected == null){
            selected = new Restaurant();
        }
        return selected;
    }

    public void setSelected(Restaurant selected) {
        this.selected = selected;
    }
    
    public String prepareView(){
        selected = (Restaurant) getRestaurant().getRowData();
        return "browse";
    }

}

