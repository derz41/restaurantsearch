/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author gabor_000
 */
public class LocationHelper {
    
    Session session = null;
    
    public LocationHelper(){
        try{
            this.session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        }  catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String selectLocation(Location l){
        
        String keyWord = l.setLocationName(userInput);
        String sql = " select location_id from location where location_name = :keyWord ";
        
        return sql;
    }
    
    public String selectRestaurant(Location l){
        
        String sql=" select * from restaurant where location_id = " 
                + (l.getLocationId());
        return sql;
    }
    
}

