/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author gabor_000
 */
@Named(value = "reservationController")
@SessionScoped
public class ReservationController implements Serializable {

    ReservationHelper helper;

    Reservation reservation;
    Reservation selected;
    DataModel detailsByUserId;

    String response;
    String delete;

    Date date;
    String time;
    int reservationId;
    int numGuests;
    int user;
    int rest;

    DataModel userValues;
    DataModel restValues;
    private boolean rendered;

    /**
     * Creates a new instance of ReservationController
     */
    public ReservationController() {
        helper = new ReservationHelper();
    }

    public ReservationHelper getHelper() {
        return helper;
    }

    public void setHelper(ReservationHelper helper) {
        this.helper = helper;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public DataModel getUserValues() {
        if (userValues == null) {
            userValues = new ListDataModel(helper.getUser());
        }
        return userValues;
    }

    public void setUserValues(DataModel userValues) {
        this.userValues = userValues;
    }

    public DataModel getRestValues() {
        if (restValues == null) {
            restValues = new ListDataModel(helper.getRestaurant());
        }
        return restValues;
    }

    public void setRestValues(DataModel restValues) {
        this.restValues = restValues;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public String getResponse() throws ParseException {
        if (date != null && time != null) {

            // calling our helper method that inserts a row into the
            // reservation table
            if (helper.insertReservation(date, time, numGuests, user, rest) == 1) {
                // insert was successful
                date = null;
                time = null;
                response = "Reservation Made.";
                return response;
            } else {
                // insert failed
                date = null;
                time = null;
                numGuests = 0;
                response = "Reservation not made.";
                return response;
            }
        } else {
            // don't display message when first and last name are not input
            response = " ";
            return response;
        }
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isRenderTable() {
        if (date == null & time == null) {
            rendered = false;
        } else {
            rendered = true;
        }
        return rendered;
    }

    public DataModel getDetailsByUserId(int userId) {
        userId = this.user;
        detailsByUserId = new ListDataModel(helper.getReservationDetailsByUserId(userId));
        return detailsByUserId;
    }

    public String prepareViewC(int restId, int userId) {
        this.user = userId;
        this.rest = restId;
        return "reservationCuisine";
    }

    public String prepareViewL(int restId, int userId) {
        this.user = userId;
        this.rest = restId;
        return "reservationLocation";
    }

    public String prepareViewN(int restId, int userId) {
        this.user = userId;
        this.rest = restId;
        return "reservationName";
    }

    public String prepareViewDetailsByUserId(int userId) {
        this.user = userId;
        return "reservationDetailsByUserId";
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String prepareViewDelete(int reservationId) {
        this.reservationId = reservationId;
        return "reservationDelete";
    }

    public Reservation getDetailsByResId(int reservationId) {
        if (reservationId == 0){
        reservationId = this.reservationId;
        selected = helper.getReservationDetailsByResId(reservationId);
        return selected;
        } else
            return selected;
    }

    public String delete() throws ParseException {
            // calling our helper method that inserts a row into the
            // reservation table
            if (helper.deleteReservationDetailsByresId(this.reservationId) == 1) {
                // insert was successful
                date = null;
                time = null;
                delete = "Reservation Deleted.";
                return "reservationDeleted";
            } else {
                // insert failed
                date = null;
                time = null;
                numGuests = 0;
                delete = "Reservation not deleted.";
                return delete;
            }
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

}
