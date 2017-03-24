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
 * @author Matt
 */
public class RestaurantHelper {
    
    Session session = null;
    
    public RestaurantHelper() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Restaurant> selectRestaurant(String keyWord) {
        List<Restaurant> restaurantList = null;
        
        String sql = "select * from restaurant "
                + "where restaurant_name like '%" + keyWord + "%'";
        
        try {
            //starting the transaction if one is not active
            if (!this.session.getTransaction().isActive()){
                session.beginTransaction();
            }
            
            //creaing query that can be executed
            SQLQuery q = session.createSQLQuery(sql);
            
            q.addEntity(Restaurant.class);
            
            //binding the values to the placeholders in the query
            //q.setParameter("keyWord", keyWord);
            
            //executing the query
            restaurantList = (List<Restaurant>) q.list();
            
            //commiting the query to the database
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return restaurantList;
    }
    
        public Restaurant getRestaurantDetails (int restId){
        
        Restaurant restaurant = null;
        
        String sql = "select * from restaurant "
                + "where restaurant_id = :id";
        
        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);
            
            q.addEntity(Restaurant.class);
            
            q.setParameter("id", restId);
            
            restaurant = (Restaurant) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return restaurant;
    }
}
