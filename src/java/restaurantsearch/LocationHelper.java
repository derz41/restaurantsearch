/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author gabor_000
 */
public class LocationHelper {

    Session session = null;

    public LocationHelper() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> selectRestaurantByLocation(String keyWord) {

        List<Restaurant> restaurantList = null;
        
            String sql = " select * from location, restaurant "
                    + "where location_name like :keyWord"
                    + " and location.location_id = restaurant.location_id";

            try {
                // starting a transaction if one isn't active
                if (!this.session.getTransaction().isActive()) {
                    session.beginTransaction();
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity(Restaurant.class);

                q.setParameter("keyWord", keyWord);

                restaurantList = (List<Restaurant>) q.list();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            return restaurantList;
        
    }
    
    public Restaurant getRestaurantDetails (int restaurantId){
        
        Restaurant restaurant = null;
        
        String sql = "select * from restaurant where restaurant_id = :id";
        
        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);
            
            q.addEntity(Restaurant.class);
            
            q.setParameter("id", restaurantId);
            
            restaurant = (Restaurant) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return restaurant;
    }
    
    
}
