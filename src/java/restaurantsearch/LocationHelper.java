/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;

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
    
    public List<NativeSQLQueryReturn> selectLocation(Location l){
        List<NativeSQLQueryReturn> result = null;

        String sql = " select location_id from location where location_name = :keyWord ";
        
        try{
            // starting a transaction if one isn't active
            if(!this.session.getTransaction().isActive()){
                session.beginTransaction();
            }
            
            //creating an actual query that can be executed
            SQLQuery q = session.createSQLQuery(sql);
            // associating our Actor POJO and table with the query
            q.addEntity(Location.class);
            
            // binding values to the placeholders in the query
            q.setParameter("keyWord", l.getKeyWord());
            
            // executing the query
            result = q.getQueryReturns();
            
            // commiting the query to the database
            session.getTransaction().commit();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String selectRestaurant(Location l){
        
        String sql=" select * from restaurant where location_id = " 
                + (l.getLocationId());
        
        return sql;
    }
    
}

