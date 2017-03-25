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
public class CuisineHelper {
    Session session = null;

    public CuisineHelper() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> selectRestaurantByCuisine(String keyWord) {

        List<Restaurant> restaurantList = null;
        
            String sql = " select * from cuisine, restaurant "
                    + "where cuisine_type like :keyWord"
                    + " and cuisine.cuisine_id = restaurant.cuisine_id";

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
