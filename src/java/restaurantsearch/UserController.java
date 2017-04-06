/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsearch;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author gabor_000
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    UserHelper helper;
    
    User current;
//    User loggedIn;
    
    String responseInsert;
    String FName;
    String LName;
    String phone;
    String email;
    
    int userId;
    
    public UserController() {
        helper = new UserHelper();
    }

    public UserHelper getHelper() {
        return helper;
    }

    public void setHelper(UserHelper helper) {
        this.helper = helper;
    }

    public User getCurrent(String email) {
        email = this.email;
        current = helper.selectUser(email);
        return current;
    }

    public void setCurrent(User current) {
        this.current = current;
    }

//    public User getLoggedIn() {
//        loggedIn = helper.selectUserById(this.current.getUserId());
//        return loggedIn;
//    }
//
//    public void setLoggedIn(User loggedIn) {
//        this.loggedIn = loggedIn;
//    }
    
    

    public String getResponseInsert() {
        if (FName != null && LName != null && phone != null && email != null) 
        {

            // calling our helper method that inserts a row into the
            // reservation table
            if (helper.insertUser(FName, LName, phone, email)== 1) {
                // insert was successful
                FName = null;
                LName = null;
                phone = null;
                email = null;
                responseInsert = "User Created.";
                return responseInsert;
            } else {
                // insert failed
                FName = null;
                LName = null;
                phone = null;
                email = null;
                responseInsert = "User not created.";
                return responseInsert;
            }
        } else {
            // don't display message when first and last name are not input
            responseInsert = " ";
            return responseInsert;
        }
    }

    public void setResponseInsert(String responseInsert) {
        this.responseInsert = responseInsert;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
    
    public User getDetails() {
        User details = helper.selectUserById(2);
        return details;
    }
//    
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
    
    public String prepareView(int userId) {
        userId = this.userId;
        return "userDetails";
    }
}