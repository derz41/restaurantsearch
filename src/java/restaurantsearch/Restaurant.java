package restaurantsearch;
// Generated Feb 23, 2017 8:41:59 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Restaurant generated by hbm2java
 */
public class Restaurant implements java.io.Serializable {

    private Integer restaurantId;
    private Cuisine cuisine;
    private Location location;
    private String restaurantName;
    private String restaurantHours;
    private String restaurantPhone;
    private String restaurantAddress;
    private Set<Reservation> reservations = new HashSet<Reservation>(0);
    private String keyWord;
    private Set<Restaurant> restaurants = new HashSet<Restaurant>(0);

    public Restaurant() {
    }

    public Restaurant(Cuisine cuisine, Location location, String restaurantName, String restaurantHours, String restaurantPhone, String restaurantAddress) {
        this.cuisine = cuisine;
        this.location = location;
        this.restaurantName = restaurantName;
        this.restaurantHours = restaurantHours;
        this.restaurantPhone = restaurantPhone;
        this.restaurantAddress = restaurantAddress;
    }

    public Restaurant(Cuisine cuisine, Location location, String restaurantName, String restaurantHours, String restaurantPhone, String restaurantAddress, Set<Reservation> reservations) {
        this.cuisine = cuisine;
        this.location = location;
        this.restaurantName = restaurantName;
        this.restaurantHours = restaurantHours;
        this.restaurantPhone = restaurantPhone;
        this.restaurantAddress = restaurantAddress;
        this.reservations = reservations;
    }

    public Integer getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Cuisine getCuisine() {
        return this.cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantHours() {
        return this.restaurantHours;
    }

    public void setRestaurantHours(String restaurantHours) {
        this.restaurantHours = restaurantHours;
    }

    public String getRestaurantPhone() {
        return this.restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String getRestaurantAddress() {
        return this.restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Set<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
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
