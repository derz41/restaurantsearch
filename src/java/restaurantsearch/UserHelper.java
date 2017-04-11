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
public class UserHelper {

    Session session = null;

    public UserHelper() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertUser(String fName, String lName, String phone, String email) {
        int result = 0;

        String sql = "insert into user(user_fname, user_lname, user_phone, "
                + "user_email) "
                + "values (:fName, :lName, :phone, :email)";
        try {
            // starting a transaction if one isn't active
            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            //creating an actual query that can be executed
            SQLQuery q = session.createSQLQuery(sql);
            // associating our Actor POJO and table with the query
            q.addEntity(User.class);

            // binding values to the placeholders in the query
            q.setParameter("fName", fName);
            q.setParameter("lName", lName);
            q.setParameter("phone", phone);
            q.setParameter("email", email);

            // executing the query
            result = q.executeUpdate();

            // commiting the query to the database
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User selectUser(String email) {
        User current = null;

        String sql = "select * from user where user_email = :email";

        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(User.class);

            q.setParameter("email", email);

            current = (User) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return current;
    }
    
    public User selectUserById(int userId) {
        User current = null;

        String sql = "select * from user where user_id = :id";

        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(User.class);

            q.setParameter("id", userId);

            current = (User) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return current;
    }
    
    public Reservation getRestaurantDetails (int userId){
        
        Reservation reservation = null;
        
        String sql = "select * from reservation "
                + "where user_id = :id";
        
        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);
            
            q.addEntity(Reservation.class);
            
            q.setParameter("id", userId);
            
            reservation = (Reservation) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return reservation;
    }
}
