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

    String response;

    Date date;
    String time;
    int numGuests;
    int user;
    int rest;

    DataModel userValues;
    DataModel restValues;

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
            if (helper.insertReservation(date,time, numGuests, user, rest) == 1) {
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

    public String prepareViewC(int restId) {
        this.rest = restId;
        return "reservationCuisine";
    }

    public String prepareViewL(int restId) {
        this.rest = restId;
        return "reservationLocation";
    }

    public String prepareViewN(int restId) {
        this.rest = restId;
        return "reservationName";
    }

}
