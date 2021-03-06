package restaurantsearch;
// Generated Feb 23, 2017 8:41:59 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Cuisine generated by hbm2java
 */
public class Cuisine implements java.io.Serializable {

    private Integer cuisineId;
    private String cuisineType;
    private String keyWord;
    private Set<Restaurant> restaurants = new HashSet<Restaurant>(0);

    public Cuisine() {
    }

    public Cuisine(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Cuisine(String cuisineType, Set<Restaurant> restaurants) {
        this.cuisineType = cuisineType;
        this.restaurants = restaurants;
    }

    public Integer getCuisineId() {
        return this.cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineType() {
        return this.cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Set<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
    
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

}
