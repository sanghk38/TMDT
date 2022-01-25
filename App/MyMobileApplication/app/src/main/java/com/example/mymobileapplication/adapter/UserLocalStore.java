package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mymobileapplication.data.User;
import com.example.mymobileapplication.data.Uxer;

public class UserLocalStore {
    public static final String SP_NAME = "user";

    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(Uxer user) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("email", user.email);
        userLocalDatabaseEditor.putString("username", user.username);
        userLocalDatabaseEditor.putString("password", user.password);
        userLocalDatabaseEditor.commit();
    }
    public void Data(User user) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("id", String.valueOf(user.ID));
        userLocalDatabaseEditor.putString("email", user.Email);
        userLocalDatabaseEditor.putString("name", user.TenKh);
        userLocalDatabaseEditor.putString("password", user.Password);
        userLocalDatabaseEditor.putString("address", user.diachi);
        userLocalDatabaseEditor.putString("phone", user.Phone);
        userLocalDatabaseEditor.commit();
    }
    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putBoolean("loggedIn", loggedIn);
        userLocalDatabaseEditor.commit();
    }

    public void clearUserData() {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.clear();
        userLocalDatabaseEditor.commit();
    }

    public Uxer getLoggedInUser() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String email = userLocalDatabase.getString("email", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");

        Uxer user = new Uxer(email, username, password);
        return user;
    }
    public User getLoggedInUser1() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String email = userLocalDatabase.getString("email", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        String phone = userLocalDatabase.getString("phone", "");
        String address = userLocalDatabase.getString("address", "");

        User users = new User(email, username, password,phone,address);
        return users;
    }
}
