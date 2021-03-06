/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author gabor_000
 */
public class ReservationHelper {

    Session session = null;

    public ReservationHelper() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertReservation(Date date, String time, int numGuests,
            int userId, int restId) {
        int result = 0;

        String sql = "insert into reservation(reservation_date, reservation_time, reservation_num_guests, "
                + "user_id, resaurant_id) "
                + "values (:date, :time, :numGuests, :userId, :restId)";
        try {
            // starting a transaction if one isn't active
            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            //creating an actual query that can be executed
            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(Reservation.class);

            // binding values to the placeholders in the query
            q.setParameter("date", date);
            q.setParameter("time", time);
            q.setParameter("numGuests", numGuests);
            q.setParameter("userId", userId);
            q.setParameter("restId", restId);

            // executing the query
            result = q.executeUpdate();

            // commiting the query to the database
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List getRestaurant() {

        // setting local variable that will be used to return list
        // of lanuages
        List<Restaurant> restaurantList = null;

        // creating query as a String
        String sql = "select * from restaurant";

        try {
            // if current transaction isn't active, begin one
            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            // creating actual query that will be executed against the database
            SQLQuery q = session.createSQLQuery(sql);

            // associating the Language POJO and table with the query
            q.addEntity(Restaurant.class);

            // executing the query
            restaurantList = (List<Restaurant>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return restaurantList;
    }

    public List getUser() {

        // setting local variable that will be used to return list
        // of lanuages
        List<User> userList = null;

        // creating query as a String
        String sql = "select * from user";

        try {
            // if current transaction isn't active, begin one
            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            // creating actual query that will be executed against the database
            SQLQuery q = session.createSQLQuery(sql);

            // associating the Language POJO and table with the query
            q.addEntity(User.class);

            // executing the query
            userList = (List<User>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public List<Reservation> getReservationDetailsByUserId(int userId) {

        List<Reservation> reservationList = null;

        String sql = "select * from reservation "
                + "where user_id = :id";

        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(Reservation.class);

            q.setParameter("id", userId);

            reservationList = (List<Reservation>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservationList;
    }

    public Reservation getReservationDetailsByResId(int resId) {

        Reservation reservation = null;

        String sql = "select * from reservation "
                + "where reservation_id = :id";

        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(Reservation.class);

            q.setParameter("id", resId);

            reservation = (Reservation) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservation;
    }

    public int deleteReservationDetailsByresId(int resId) {

        int result = 0;

        String sql = "delete from reservation "
                + "where reservation_id = :resId";

        try {

            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(Reservation.class);

            // binding values to the placeholders in the query
            q.setParameter("resId", resId);

            // executing the query
            result = q.executeUpdate();
            
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public int updateReservation(Date date, String time, int numGuests,
            int userId, int restId, int reservationId) {
        int result = 0;

        String sql = "update reservation set reservation_date = :date, "
                + "reservation_time = :time, reservation_num_guests = :numGuests, "
                + "user_id = :userId, resaurant_id = :restId "
                + "where reservation_id = :reservationId";
        try {
            // starting a transaction if one isn't active
            if (!this.session.getTransaction().isActive()) {
                session.beginTransaction();
            }

            //creating an actual query that can be executed
            SQLQuery q = session.createSQLQuery(sql);

            q.addEntity(Reservation.class);

            // binding values to the placeholders in the query
            q.setParameter("date", date);
            q.setParameter("time", time);
            q.setParameter("numGuests", numGuests);
            q.setParameter("userId", userId);
            q.setParameter("restId", restId);
            q.setParameter("reservationId", reservationId);

            // executing the query
            result = q.executeUpdate();

            // commiting the query to the database
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
